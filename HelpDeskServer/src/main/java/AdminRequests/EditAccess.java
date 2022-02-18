package AdminRequests;

import Entites.Access;

public class EditAccess extends AdminRequest{

    public EditAccess(String message) {
        super(message);
    }

    /**
     * Запрос приходит в формате /admEdiA id description
     * @param message Входящее сообщение
     * @return Возвращает null
     */
    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s",3);
        Access access = service.findAccessByID("SELECT * FROM access WHERE flag = " + tokens[1]);
        access.setDescription(tokens[2]);
        service.updateAccess(access);
        return null;
    }
}
