package AdminRequests;

import Entites.Priority;

public class DeletePriority extends AdminRequest{

    public DeletePriority(String message) {
        super(message);
    }

    @Override
    protected Object request(String message) {
        String[] tokens = message.split("\\s");
        Priority priority = service.findPriority(Integer.parseInt(tokens[1]));
        service.deletePriority(priority);
        return null;
    }
}
