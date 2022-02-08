import Services.UserRequestService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(8888)){

            socket = serverSocket.accept();
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            while (true){
                String messageFromClient = inputStream.readUTF();
                /**
                 * Блок обработки запроса от пользователя
                 * на создание заявки
                 */
                if (messageFromClient.startsWith("/request ")){
                    String[] tokens = messageFromClient.split("\\s", 2);
                    String[] request = new UserRequestService().processingRequest(tokens[1]);
                    outputStream.writeUTF("/requestComplete" + request[0]/*номер заявки*/);//Отправка клиенту ответа на запрос
                }
                if (messageFromClient.equals("/stopServer")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
