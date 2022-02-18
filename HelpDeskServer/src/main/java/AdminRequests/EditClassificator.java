package AdminRequests;

import Entites.Statementtype;

public class EditClassificator extends AdminRequest{

    public EditClassificator(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s",3);
        Statementtype type = service.findStateTypeById("SELECT * FROM statementtype WHERE flag = " + tokens[1]);
        type.setDescription(tokens[2]);
        service.updateStateType(type);
        return null;
    }
}
