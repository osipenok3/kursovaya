package servlets;

import models.Ticket;
import models.User;
import services.TicketRepository;
import services.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private final TicketRepository ticketRepository = new TicketRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_user = (Integer) req.getSession(false).getAttribute("id_user");
        List<Ticket> tickets = ticketRepository.getTicketByIdUser(id_user);
        req.setAttribute("tickets", tickets);
        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
        resp.setContentType("text/html");
    }

}
