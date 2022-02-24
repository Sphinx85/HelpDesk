package Services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

    private final Vector<ClientHandler> clients;

    public Server() {
        clients = new Vector<>();
        try (ServerSocket serverSocket = new ServerSocket(8888)){
            while (true){
                Socket socket = serverSocket.accept();
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client){
        clients.remove(client);
    }

    public Vector<ClientHandler> userList(){
        return clients;
    }
}
