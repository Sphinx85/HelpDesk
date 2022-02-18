package AdminRequests;

import Entites.Users;

public class EditUser extends AdminRequest{

    public EditUser(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s",6); // "/admEdiU id firsName secondName lastName flag"
        Users user = service.findUser(Integer.parseInt(tokens[1]));
        user.setFirstname(tokens[2]);
        user.setSecondname(tokens[3]);
        user.setLastname(tokens[4]);
        user.setAccess_id(Integer.parseInt(tokens[5]));
        return null;
    }
}
