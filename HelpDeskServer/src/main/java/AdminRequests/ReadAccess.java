package AdminRequests;

public class ReadAccess extends AdminRequest{

    public ReadAccess(String message) {
        super(message);
    }

    @Override
    public Object request(String message) {
        return service.findAccessByQuery("SELECT flag, description FROM access");
    }
}