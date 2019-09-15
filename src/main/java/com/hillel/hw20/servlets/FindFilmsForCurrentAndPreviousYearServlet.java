package com.hillel.hw20.servlets;

import com.hillel.hw20.dbUtils.DBWork;
import com.hillel.hw20.film.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findFilmsForCurrentAndPreviousYear")
public class FindFilmsForCurrentAndPreviousYearServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/findFilmsForCurrentAndPreviousYear.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBWork dbWork = new DBWork();
        List<Film> filmList = dbWork.findFilmsForCurrentAndPreviousYear();
        request.setAttribute("filmList", filmList);
        request.getRequestDispatcher("/jsp/findFilmsForCurrentAndPreviousYear.jsp").forward(request, response);

    }
}
