package Authentication;

import Entites.Users;
import Services.UserService;

public class LogInService implements AuthService{

    public LogInService() {
    }

    @Override
    public Users logIn(String message) {
        UserService service = new UserService();
        String[] tokens = message.split("\\s");

        return service.findUserByLogIn(tokens[1]);
    }
}
