package AdminRequests;

import Entites.Access;

public class DeleteAccess extends AdminRequest{

    public DeleteAccess(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Access access = service.findAccessByID("SELECT * FROM access WHERE flag = " + tokens[1]);
        service.deleteAccess(access);
        return null;
    }
}
