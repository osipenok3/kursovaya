package servlets;

import models.Film;
import models.Session;
import services.FilmRepository;
import services.SessionRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/poster/*")
public class PosterServlet extends HttpServlet {
    private final FilmRepository filmRepository = new FilmRepository();
    private final SessionRepository sessionRepository = new SessionRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null || path.isEmpty()) {
            List<Film> films = filmRepository.getAllFilms();
            req.setAttribute("films", films);
            req.getRequestDispatcher("/pages/poster.jsp").forward(req, resp);
        }

        assert path != null;
        String userId = path.split("/")[1];
        int id = Integer.parseInt(userId);
        Film film = filmRepository.getFilmById(id);
        List<Session> sessions = sessionRepository.getSessionsByIdFilm(id);
        req.setAttribute("film", film);
        req.setAttribute("sessions", sessions);
        req.getRequestDispatcher("/pages/film.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        int id = Integer.parseInt(req.getParameter("id"));
        resp.sendRedirect(req.getContextPath() + "/order/" + id);
    }

}
