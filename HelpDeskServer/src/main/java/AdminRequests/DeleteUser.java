package AdminRequests;

import Entites.Users;

public class DeleteUser extends AdminRequest{

    public DeleteUser(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Users user = service.findUser(Integer.parseInt(tokens[1]));
        service.deleteUser(user);
        return null;
    }
}
