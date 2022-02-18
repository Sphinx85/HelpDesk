package AdminRequests;

import Entites.Statementtype;

public class DeleteClassificator extends AdminRequest{

    public DeleteClassificator(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Statementtype type = service.findStateTypeById("SELECT * FROM statementtype WHERE flag = " + tokens[1]);
        service.deleteStateType(type);
        return null;
    }
}