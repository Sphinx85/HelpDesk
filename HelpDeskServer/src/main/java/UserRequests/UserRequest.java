package UserRequests;

import Services.UserService;

public abstract class UserRequest {
    protected UserService service;

    protected UserRequest(String message) {
        this.service = new UserService();

        request(message);
    }

    protected abstract Object request(String message);
}