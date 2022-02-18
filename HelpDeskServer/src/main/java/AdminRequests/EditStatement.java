package AdminRequests;

import Entites.Statement;

public class EditStatement extends AdminRequest{

    public EditStatement(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s",6); // "/admEdiS id user_id type_id priority_id description"
        Statement statement = service.findStateById(Integer.parseInt(tokens[1]));
        statement.setDescription(tokens[5]);
        statement.setPriority_id(4);
        statement.setType_id(3);
        statement.setUser_id(2);
        service.updateStatement(statement);
        return null;
    }
}
