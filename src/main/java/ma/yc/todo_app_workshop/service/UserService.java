package ma.yc.todo_app_workshop.service;

import ma.yc.todo_app_workshop.entity.Todo;
import ma.yc.todo_app_workshop.entity.User;

import java.util.ArrayList;

public interface UserService {

    public boolean login(String username, String password);
    public boolean register(String username, String password, String email);
    public boolean logout();
    public boolean isLogged();
    public boolean assigneUserToTask(Todo todo);
    public ArrayList<User> getAllUsers();
    public User getUserById(Long id);


    User getUserByUsername(String username);
}
