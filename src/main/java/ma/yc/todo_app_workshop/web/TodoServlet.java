package ma.yc.todo_app_workshop.web;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.todo_app_workshop.entity.User;
import ma.yc.todo_app_workshop.service.TodoService;
import ma.yc.todo_app_workshop.service.UserService;
import ma.yc.todo_app_workshop.service.impl.TodoServiceImpl;
import ma.yc.todo_app_workshop.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "todoServlet", value = "/todo-servlet")
public class TodoServlet extends HttpServlet {

    private UserService userService;
    private TodoService todoService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.userService = new UserServiceImpl();
        this.todoService =  new TodoServiceImpl();
        super.init(config);
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //SEND ALL TODOS TO THE VIEW JSP
        User user = userService.getUserById(1L);
        req.setAttribute("user",user);
        req.getRequestDispatcher("views/todo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ADD NEW TODO
        Long id = req.getAttribute("id") != null ? Long.parseLong(req.getAttribute("id").toString()) : null;
        String title = req.getParameter("task");
//        if (id == null || title == null || title.isEmpty()){
//            resp.sendRedirect("todo-servlet");
//            return;
//        }
        this.todoService.addNewTodoToUser(id,title);
        User user = userService.getUserById(1L);

        req.setAttribute("user", user );
        req.getRequestDispatcher("views/todo.jsp").forward(req,resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    
}
