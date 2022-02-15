package UserRequests;

import Entites.Statement;
import Services.ClientHandler;

public class NewStatement extends UserRequest {

    private final ClientHandler client;

    public NewStatement(String message, ClientHandler client) {
        super(message);
        this.client = client;
    }

    /**
     * Запрос должен приходить в формате /newstate Текст самого сообщения до конца строки
     * @param message
     */
    @Override
    public Object request(String message) {
        String[] tokens = message.split("\\s", 2);
        Statement statement = new Statement(tokens[1],client.getUserID(),client.getTypeID(),client.getPriorityID());
        service.saveStatement(statement);
        return statement;
    }
}