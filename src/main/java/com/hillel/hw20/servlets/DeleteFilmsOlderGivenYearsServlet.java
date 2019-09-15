package com.hillel.hw20.servlets;

import com.hillel.hw20.dbUtils.DBWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFilmsOlderGivenYears")
public class DeleteFilmsOlderGivenYearsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/deleteFilmsOlderGivenYears.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBWork dbWorker = new DBWork();
        int yearToDelete = Integer.parseInt(request.getParameter("yearToDelete"));
        int count = dbWorker.deleteFilmsOlderGivenYears(yearToDelete);
        request.setAttribute("count", count);
        request.getRequestDispatcher("/jsp/deleteFilmsOlderGivenYears.jsp").forward(request, response);

    }
}
