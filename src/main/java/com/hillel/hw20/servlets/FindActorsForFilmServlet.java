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

@WebServlet("/findActorsForFilm")
public class FindActorsForFilmServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/findActorsForFilm.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBWork dbWorker = new DBWork();
        String filmName = request.getParameter("filmName");
        List<Actor> actorList = dbWorker.findActorForFilm(filmName);
        request.setAttribute("actorList", actorList);
        request.getRequestDispatcher("/jsp/findActorsForFilm.jsp").forward(request, response);

    }

}
