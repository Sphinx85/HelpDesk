package AdminRequests;

import Entites.Priority;

public class EditPriority extends AdminRequest{

    public EditPriority(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s",3);
        Priority priority = service.findPriority(Integer.parseInt(tokens[1]));
        priority.setDescription(tokens[2]);
        service.updatePriority(priority);
        return null;
    }
}
