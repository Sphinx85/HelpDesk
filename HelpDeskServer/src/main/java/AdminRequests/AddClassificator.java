package AdminRequests;

import Entites.Statementtype;

public class AddClassificator extends AdminRequest{
    public AddClassificator(String message) {
        super(message);
    }

    /**
     * Запрос приходит в формате /admNewClassificator id description
     * @param message Входящее сообщение
     * @return возвращает строку для уведомления
     */
    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Statementtype type = new Statementtype(Integer.parseInt(tokens[1]),tokens[2]);
        service.saveStateType(type);
        return null;
    }
}