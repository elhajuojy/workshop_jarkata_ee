
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ma.yc.todo_app_workshop.entity.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Date" %>
<%@ page import="ma.yc.todo_app_workshop.enums.Progress" %>
<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
    }
//    User user = (User) session.getAttribute("user");

    assert user != null;%>
<html>
<head>
    <title>Todo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container">
    <div class="user-info">
        <h1>Welcome - <%=user.getUsername()%></h1>
    </div>
    <div class="card-body p-5">

        <form action="todo-servlet" method="post" class="d-flex justify-content-center align-items-center mb-4">
            <div class="form-outline flex-fill">
                <label class="form-label" for="task">New Task</label>
                <input type="text" id="task" name="task"  class="form-control"  />
            </div>
            <input type="hidden" name="id" value="<%=user.getId()%>" />
            <button type="submit" class="btn btn-info ms-2 mt-auto">Add</button>
        </form>
    </div>
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-top align-items-center ">
                <div class="col col-lg-8 col-xl-6">
                    <div class="card rounded-3">
                        <div class="card-body p-4">
                            <p class="mb-2"><span class="h2 me-2">Team Meeting</span> <span
                                    class="badge bg-danger">checklist</span></p>
                            <p class="text-muted pb-2">
                                <%=new Date().toString()%> • ML - 1321</p>

                            <ul class="list-group rounded-0">
                                <% assert user != null;
                                    for (Todo todo : user.getTodos()) { %>
                                <li class="list-group-item border-0 d-flex align-items-center ps-0">
                                    <input class="form-check-input me-3" type="checkbox" value="" aria-label="..." checked />
                                    <% if (todo.getProgress() == Progress.COMPLETED) { %> <s>   <%=todo.getTitle() %> </s> <% } %>
                                    <% if (todo.getProgress() == Progress.IN_PROGRESS) { %> <%=todo.getTitle() %> <% } %>
                                    <% if (todo.getProgress() == Progress.NOT_STARTED) { %> <b> <%=todo.getTitle() %> </b> <% } %>

                                </li>
                                <% } %>
                            </ul>


                        </div>
                    </div>
                </div>
            </div>
        </div>




<%--<% for (Todo todo : user.getTodos()) { %>--%>
<%--<table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">Todo</th>--%>
<%--        <th scope="col">Done</th>--%>
<%--        <th scope="col">Remove</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <tr class="odd-row-color">--%>
<%--        <td scope="row"><%= todo.getTitle() %></td>--%>
<%--        <td><input type="checkbox" name="done" value="done"></td>--%>
<%--        <td><a class="btn btn-primary" href="todo?remove=<%= todo.getId() %>">Remove</a></td>--%>
<%--    </tr>--%>
<%--</table>--%>

<%--<% } %>--%>
</body>
</html>
