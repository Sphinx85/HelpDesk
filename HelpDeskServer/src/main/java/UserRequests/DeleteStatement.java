package UserRequests;

public class DeleteStatement extends UserRequest{


    public DeleteStatement(String message) {
        super(message);
    }

    /**
     * Запрос приходит в формате /edistate state_id
     * Метод удаляет заявку по запросу пользователя
     * @param message входящее сообщение
     * @return Возвращает пользователю сообщение об удалении заявки
     */
    @Override
    public Object request(String message) {
        String[] tokens = message.split("\\s");
        service.deleteStatementByID(tokens[1]);
        return "Заявка " + tokens[1] + " удалена";
    }
}