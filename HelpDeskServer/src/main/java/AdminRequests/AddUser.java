package AdminRequests;

import Entites.Users;

public class AddUser extends AdminRequest{
    public AddUser(String message) {
        super(message);
    }

    /**
     * Запрос приходит в формате /admNewUser firstName secondName lastName access_id
     * @param message Входящее сообщение
     * @return возвращает строку для уведомления
     */
    @Override
    public Object request(String message) {
        String[] tokens = message.split("\\s");
        Users user = new Users(tokens[1],tokens[2],tokens[3],Integer.parseInt(tokens[4]));
        service.saveUser(user);
        return tokens[1] + " " + tokens[2] + " " + tokens[3];
    }
}