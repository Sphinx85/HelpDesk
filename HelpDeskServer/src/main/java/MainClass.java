import Entites.Statement;
import Entites.Users;
import Services.UserService;

public class MainClass {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Statement statement = new Statement("test2");
        Statement statement1 = new Statement("new konstruktor", 6,570,1);

        System.out.println(statement1.getUser().getId());
        System.out.println(statement1.getPriority().getId());
        System.out.println(statement1.getType().getId());
        userService.saveStatement(statement1);

        //userService.saveStatement(new Statement("test new"));
        //System.out.println(userService.findStateById(13).getDescription() + " " + userService.findUser(userService.findStateById(13).getUser().getId()).getFirstname());
    }
}
