package UserRequests;

import Entites.Statement;
import Services.ClientHandler;

public class ReadStatement extends UserRequest {

    private final ClientHandler client;

    public ReadStatement(String message, ClientHandler clientHandler) {
        super(message);
        this.client = clientHandler;
    }

    /**
     * Запрос должен приходить в формате /wiestate state_id
     * Данный класс формирует два результата запроса:
     * Для получения информации о конкретной заявке, все части сообщения должны быть заполнены
     * Для получения списка заявок, отправленных пользователем, state_id должно быть равно 0
     * @param message Входящее сообщение
     */
    @Override
    public Object request(String message) {
        String[] tokens = message.split("\\s");
        Statement statement = new Statement("", client.getUserID(), client.getTypeID(),client.getPriorityID());
        statement.setDescription(service.findStateById(Integer.parseInt(tokens[1])).getDescription());

        if (tokens[1].equals("0")){
            /**
             * Метод возвращающий список заявок пользователя
             */
            return service.findStatesByQuery("SELECT stateid, description, user_id, type_id, priority_id FROM statements WHERE user_id = " + client.getUserID());
        } else {
            /**
             * Метод, возвращающий информацию о заявке
             */
            return statement;
        }
    }
}