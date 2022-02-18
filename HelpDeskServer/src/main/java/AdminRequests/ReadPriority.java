package AdminRequests;

public class ReadPriority extends AdminRequest{
    public ReadPriority(String message) {
        super(message);
    }

    @Override
    public Object request(String message) {
        return service.findPriorityByQuery("SELECT id, description FROM priority");
    }
}