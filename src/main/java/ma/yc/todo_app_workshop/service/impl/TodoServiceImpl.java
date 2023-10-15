package ma.yc.todo_app_workshop.service.impl;

import jakarta.persistence.EntityManager;
import ma.yc.todo_app_workshop.connection.Jpa;
import ma.yc.todo_app_workshop.entity.Todo;
import ma.yc.todo_app_workshop.entity.User;
import ma.yc.todo_app_workshop.enums.Priority;
import ma.yc.todo_app_workshop.enums.Progress;
import ma.yc.todo_app_workshop.service.TodoService;
import ma.yc.todo_app_workshop.service.UserService;

public class TodoServiceImpl implements TodoService {
    private UserService userService;
    EntityManager em = Jpa.getInstance().getEntityManager();

    public TodoServiceImpl() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public void addNewTodoToUser(Long id, String title) {
//        User user = this.userService.getUserById(id);
        User user = em.find(User.class, 1);
        if (user != null && title != null) {

            try{
                em.getTransaction().begin();
                Todo todo = new Todo();
                todo.setTitle(title);
                todo.setDescription("description for "+ title) ;
                todo.setPriority(Priority.HIGH);
                todo.setProgress(Progress.NOT_STARTED);
                todo.setUser(user);
                em.persist(todo);
                user.getTodos().add(todo);
                em.getTransaction().commit();
            }catch (Exception e){
                em.getTransaction().rollback();
            }
            finally {
            }

        }


    }
}
