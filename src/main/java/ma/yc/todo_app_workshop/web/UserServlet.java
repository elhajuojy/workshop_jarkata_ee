package ma.yc.todo_app_workshop.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.todo_app_workshop.entity.User;
import ma.yc.todo_app_workshop.service.UserService;
import ma.yc.todo_app_workshop.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {

    private UserService userService ;

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl();
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //SEND EMPTY USER TO THE VIEW JSP BUT WHEN HE WRITE DOWN HIS INFORMATION
        // AND SEND ANOTHER GET WE WILL CHECK IF THE USER IS LOGGED OR NOT
        User user = new User();

        req.setAttribute("user",user);
        req.getRequestDispatcher("views/user.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        if (req.getParameter("username") != null && req.getParameter("password") != null){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username+" "+password);
            if (userService.login(username,password)){
                user = userService.getUserByUsername(username);
                req.setAttribute("user",user);
                req.getRequestDispatcher("views/todo.jsp").forward(req,resp);
                return;
            }
        }

        req.setAttribute("user",user);
        req.getRequestDispatcher("views/user.jsp").forward(req,resp);
        req.setAttribute("error","username or password incorrect");


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
