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

    public ClientHandler(Server server, Socket socket){
        try{
            this.server = server;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());

            while (true){
                server.subscribe(this);
                String message = inputStream.readUTF();
                if (message.startsWith("/request ")){
                    String[] tokens = message.split("\\s",2);
                    new UserRequestService(tokens[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
