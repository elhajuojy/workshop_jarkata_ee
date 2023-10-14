package ma.yc.todo_app_workshop.service;

import ma.yc.todo_app_workshop.entity.User;

public interface UserService {

    public boolean login(String username, String password);
    public boolean register(String username, String password, String email);
    public boolean logout();
    public boolean isLogged();
    public boolean assigneUserToTask(String username, User todo );



}
