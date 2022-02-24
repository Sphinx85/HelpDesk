package Services;

import Authentication.LogInService;
import Entites.Users;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private static final SwitchService switchService = new SwitchService();
    private int userID;
    private UserService service;
    private int typeID;
    private int priorityID;

    public ClientHandler(Server server, Socket socket){
        try{
            this.server = server;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.service = new UserService();
            //this.userID = service.findUser(6).getId(); Временный комментарий. Старая разработка
            this.typeID = 570;
            this.priorityID = 1;

            new Thread(() ->{
                /**
                 * Цикл аутентификации
                 */
                while (true){
                    try {
                        String message = inputStream.readUTF();
                        if (message.startsWith("/auth")){
                            LogInService inService = new LogInService();
                            Users thisUser = inService.logIn(message);
                            this.userID = thisUser.getId();
                            if (userID > 0){
                                server.subscribe(this);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                /**
                 * Цикл взаимодействия с клиентом
                 */
                while (true){
                    try{
                        String message = inputStream.readUTF();
                        if (message.startsWith("/")){
                            if (message.startsWith("/adm")){
                                outputStream.writeUTF(switchService.adminRequestSwitcher(message));
                                continue;
                            }
                            outputStream.writeUTF(switchService.userRequestSwitcher(message,this));
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    } finally {
                        disconnect();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        server.unsubscribe(this);

        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getUserID() {
        return userID;
    }

    public int getTypeID() {
        return typeID;
    }

    public int getPriorityID() {
        return priorityID;
    }
}