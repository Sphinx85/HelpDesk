package AdminRequests;

import Services.UserService;

public abstract class AdminRequest {

    protected UserService service;

    protected AdminRequest(String message) {
        this.service = new UserService();
        request(message);
    }

    protected abstract Object request(String message);
}