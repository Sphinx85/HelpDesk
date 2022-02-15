package Services;

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
            this.userID = service.findUser(6).getId();
            this.typeID = service.findStateType(570).getId();
            this.priorityID = service.findPriority(1).getId();

            new Thread(() ->{

                while (true){
                    server.subscribe(this);
                    break;
                }

                while (true){
                    try{

                        String message = inputStream.readUTF();

                        if (message.startsWith("/")){
                            outputStream.writeUTF(switchService.userRequestSwitcher(message,this));
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }

                }
            });


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