package com.hillel.hw20.servlets;

import com.hillel.hw20.dbUtils.DBWork;
import com.hillel.hw20.person.Actor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findActorsForNFilm")
public class FindActorsForNFilmsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/findActorsForNFilm.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBWork dbWorker = new DBWork();
        int count = Integer.parseInt(request.getParameter("count"));
        List<Actor> actorList = dbWorker.findActorsForNFilms(count);
        request.setAttribute("actorList", actorList);
        request.getRequestDispatcher("/jsp/findActorsForNFilm.jsp").forward(request, response);

    }

}
