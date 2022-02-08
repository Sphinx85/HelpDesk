import Entites.Priority;
import Entites.Statement;
import Entites.Statementtype;
import Entites.Users;
import Services.UserService;

public class MainClass {
    public static void main(String[] args) {
        UserService userService = new UserService();



        Priority priority = new Priority();
        priority.setDescription("normal");
        userService.savePriority(priority);




    }
}
