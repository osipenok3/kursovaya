package servlets;

import models.Ticket;
import services.TicketRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ticket/*")
public class TicketServlet extends HttpServlet {
    private final TicketRepository ticketRepository = new TicketRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        assert path != null;
        String userId = path.split("/")[1];
        int id = Integer.parseInt(userId);
        Ticket ticket = ticketRepository.getTicketById(id);
        req.setAttribute("ticket", ticket);
        req.getRequestDispatcher("/pages/ticket.jsp").forward(req, resp);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        int id_user = (Integer) req.getSession(false).getAttribute("id_user");
        String path = req.getPathInfo();
        assert path != null;
        String userId = path.split("/")[1];
        int id = Integer.parseInt(userId);
        if (req.getParameter("code").equals("1234")) {
            ticketRepository.setStatusTicket(id_user,id);
            req.setAttribute("errorText", "Оплата прошла успешно");
        } else {
            req.setAttribute("errorText", "Ошибка оплаты");
        }
        this.doGet(req, resp);
    }
}
