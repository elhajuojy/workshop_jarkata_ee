package ma.yc.todo_app_workshop.service.impl;

import ma.yc.todo_app_workshop.connection.Jpa;
import ma.yc.todo_app_workshop.entity.Todo;
import ma.yc.todo_app_workshop.entity.User;
import ma.yc.todo_app_workshop.enums.Priority;
import ma.yc.todo_app_workshop.enums.Progress;
import ma.yc.todo_app_workshop.service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements ma.yc.todo_app_workshop.service.UserService{

    private Jpa jpa =  Jpa.getInstance();
    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(String username, String password, String email) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean isLogged() {
        return false;
    }

    @Override
    public boolean assigneUserToTask(String username, User todo) {
        User user = new User();
        user.setEmail("elmahdi@gmail.com");
        user.setUsername("elhjoujye");
        user.setPassword("passwordNeedToBeHashed");
        Todo todo1 = new Todo();
        todo1.setTitle("JAVA EE INSTALLATION ");
        todo1.setDescription(" JAVA EE DESCRIPTION ");
        todo1.setProgress(Progress.IN_PROGRESS);
        todo1.setPriority(Priority.HIGH);

        Todo todo2 = new Todo();
        todo2.setTitle("DOCKER INSTALLATION");
        todo2.setDescription("description");
        todo2.setProgress(Progress.COMPLETED);
        todo2.setPriority(Priority.LOW);



        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        user.setTodos(todos);


        try{

            this.jpa.beginTransaction();
            this.jpa.getEntityManager().persist(user);
            this.jpa.getEntityManager().persist(todo1);
            this.jpa.getEntityManager().persist(todo2);

            this.jpa.commit();

        }catch (Exception e){
            System.out.println(e.toString());
            this.jpa.rollback();
        }finally {
            this.jpa.close();
        }


        return false;

    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.assigneUserToTask("",null);
    }
}
