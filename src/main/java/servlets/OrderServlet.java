package servlets;

import models.Film;
import models.Place;
import models.Session;
import models.Ticket;
import services.FilmRepository;
import services.PlacesRepository;
import services.SessionRepository;
import services.TicketRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
    private final FilmRepository filmRepository = new FilmRepository();
    private final SessionRepository sessionRepository = new SessionRepository();
    private final PlacesRepository placesRepository = new PlacesRepository();
    private final TicketRepository ticketRepository = new TicketRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        assert path != null;
        String userId = path.split("/")[1];
        int id = Integer.parseInt(userId);
        Session session = sessionRepository.getSessionById(id);
        Film film = filmRepository.getFilmById(session.getFilm());
        List<Place> places = placesRepository.getFreePlacesByIdSession(id);
        req.setAttribute("places", places);
        req.setAttribute("session", session);
        req.setAttribute("film", film);
        req.getRequestDispatcher("/pages/order.jsp").forward(req, resp);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        String path = req.getPathInfo();
        assert path != null;
        String userId = path.split("/")[1];
        int id_session = Integer.parseInt(userId);
        int id_place = Integer.parseInt(req.getParameter("choice"));
        Ticket ticket = ticketRepository.getTicketId(id_session,id_place);
        int id_ticket = ticket.getId();
        resp.sendRedirect(req.getContextPath() + "/ticket/" + id_ticket);
    }
}
