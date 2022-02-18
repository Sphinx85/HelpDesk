package AdminRequests;

import Entites.Access;

public class AddAccess extends AdminRequest{

    public AddAccess(String message) {
        super(message);
    }

    /**
     * Запрос приходит в формате /admNewAccess description
     * @param message Входящее сообщение
     * @return возвращает строку для уведомления
     */
    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Access access = new Access(tokens[1]);
        service.saveAccess(access);
        return null;
    }
}