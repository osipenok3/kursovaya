package servlets;

import models.User;
import services.LoginService;
import services.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("errorText", "");
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
            resp.setContentType("text/html");
            super.doGet(req, resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        User users = new User(req);
        LoginService loginService = new LoginService();
        if(loginService.auth(users.getLogin(), users.getPassword())){
            String login = users.getLogin();
            int id_user = userRepository.getIdUserByLogin(login);
            HttpSession session = req.getSession();
            session.setAttribute("id_user",id_user);
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.setAttribute("errorText", "Неверно введены данные. Попробуйте ещё раз");
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
            super.doPost(req, resp);
        }

    }
}
