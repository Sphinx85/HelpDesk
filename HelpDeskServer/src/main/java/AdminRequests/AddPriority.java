package AdminRequests;

import Entites.Priority;

public class AddPriority extends AdminRequest{
    public AddPriority(String message) {
        super(message);
    }

    /**
     * Запрос приходит в формате /admNewPriority description
     * @param message Входящее сообщение
     * @return возвращает строку для уведомления
     */
    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Priority priority = new Priority(tokens[1]);
        service.savePriority(priority);
        return null;
    }
}