package UserRequests;

import Services.UserService;

public abstract class UserRequest {
    public UserService service;
    public String message;


    protected UserRequest(String message) {
        this.service = new UserService();
        this.message = message;
        request(message);
    }

    public abstract Object request(String message);
}