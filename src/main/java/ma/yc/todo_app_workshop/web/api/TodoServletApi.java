package ma.yc.todo_app_workshop.web.api;


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

@WebServlet(name = "todoServlet", value = "/api/todo-servlet")
public class TodoServletApi extends HttpServlet {

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

        //RETURN ALL TODOS DID BY THE USER
        String id  =  req.getParameter("id") == null ? null : req.getParameter("id");
        if (id == null){
            resp.sendRedirect("todo-servlet");
            return;
        }
        User user = userService.getUserById(Long.parseLong(id));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //working with json type and converting this Collection of todos to json type and send it to the client
        resp.getWriter().write(user.getTodos().toString());




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
