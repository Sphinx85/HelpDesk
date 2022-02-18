package AdminRequests;

public class ReadUser extends AdminRequest{

    public ReadUser(String message) {
        super(message);
    }

    @Override
    public Object request(String message) {
        return service.findAllUsers();
    }
}