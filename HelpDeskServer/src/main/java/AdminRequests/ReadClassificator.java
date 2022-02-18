package AdminRequests;

public class ReadClassificator extends AdminRequest{

    public ReadClassificator(String message) {
        super(message);
    }

    @Override
    public Object request(String message) {
        return service.findStateTypeByQuery("SELECT flag, description FROM statementtype");
    }
}