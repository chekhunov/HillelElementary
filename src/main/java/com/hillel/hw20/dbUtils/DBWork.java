package com.hillel.hw20.dbUtils;


import com.hillel.hw20.film.Film;
import com.hillel.hw20.person.Actor;
import com.hillel.hw20.person.Role;
import com.hillel.hw20.person.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBWork {


    public List<Film> findFilmsForCurrentAndPreviousYear() {
        String query = "SELECT id, title, date_of_release, country_of_release FROM homeLibrary.Film\n " +
                "WHERE date_of_release >= 1980 AND date_of_release <= 1981";
        List<Film> films = new ArrayList<Film>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                films.add(addFilmToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return films;
    }

    private Film addFilmToList(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        int id = 0;
        String titleOfFilm = "";
        int releaseDate = 0;
        String releaseCountry = "";

        try {
            id = resultSet.getInt(1);
            titleOfFilm = resultSet.getString(2);
            releaseDate = resultSet.getInt(3);
            releaseCountry = resultSet.getString(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Film(id, titleOfFilm, releaseDate, releaseCountry);
    }

    public List<Actor> findActorForFilm(String filmName) {
        List<Actor> actorList = new ArrayList<>();

        String query = "SELECT name FROM actor WHERE id IN\n" +
                "(SELECT actor_id FROM films_and_actors WHERE film_id =\n" +
                "(SELECT id FROM film WHERE title = '" + filmName + "'))";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actorList.add(addActorToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return actorList;
    }

    public List<Actor> findActorsForNFilms(int filmsCount) {
        List<Actor> actorList = new ArrayList<>();

        String query = "SELECT name FROM actor WHERE id = EXISTS\n" +
                "(SELECT actor_id, COUNT(*) c FROM films_and_actors GROUP BY actor_id HAVING c =" + filmsCount + ")";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actorList.add(addActorToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return actorList;

    }

    private Actor addActorToList(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        String fullName = "";

        try {
            fullName = resultSet.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Actor(fullName);
    }

    public User findUserForBD(String userName, String password) {
        User userList = null;

        String query = "SELECT * FROM homelibrary.user WHERE userName = '" + userName + "' AND password = '" + password + "'";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userList=addUserToList(resultSet);
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return userList;
    }

    private User addUserToList(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        int id = 0;
        String userName = "";
        Role role = null;
        String password = "";

        try {
            id = resultSet.getInt(1);
            userName = resultSet.getString(2);
            role = Role.valueOf(resultSet.getString(3));
            password = resultSet.getString(4);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new User(id, userName, role, password);
    }

    public List<Actor> findActorsAsDirector() {
        List<Actor> actorList = new ArrayList<>();

        String query = "SELECT * FROM director\n" +
                "  WHERE director.name LIKE '%Robert Downey Jr.%' AND director.date_of_birth = '1965' LIMIT 1;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actorList.add(addActorToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return actorList;

    }

    public int deleteFilmsOlderGivenYears(int givenYears) {
        int count = 0;
        String query = "DELETE FROM film\n " +
                "WHERE date_of_release = " + givenYears;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            count = preparedStatement.executeUpdate();

        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return count;
    }

    private void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        closeResultSet(resultSet);
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            return;
        }

        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            return;
        }

        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
