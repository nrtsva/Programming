package server.manager;

import server.data.*;
import server.data.Color;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class DBManager {
    private Properties info;
    private Connection connection;

    public DBManager(Properties info) {
        this.info = info;

        try {
            /** Connect to DB */
            connectionToDB();

            /** Create DB's tables */
            createUsersTable();
            createColorsTable();
            createTypesTable();
            createCharactersTable();
            createDragonsTable();
        } catch (SQLException e) {
            System.err.println("Не удалось подключиться к базе данных");
            e.printStackTrace();
        }

    }

    /** Conection */
    private void connectionToDB() throws SQLException {
        String url = info.getProperty("url");
        String login = info.getProperty("login");
        String password = info.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    /** Creating tables */
    private void createUsersTable() throws SQLException {
        PreparedStatement userPrSt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS users(" +
                        "ID BIGSERIAL PRIMARY KEY," +
                        "login VARCHAR UNIQUE NOT NULL," +
                        "password VARCHAR NOT NULL)");
        userPrSt.executeUpdate();
    }
    private void createColorsTable() throws SQLException {
        /** Creating */
        PreparedStatement colorsPrSt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS colors(" +
                        "color VARCHAR PRIMARY KEY NOT NULL)");

        colorsPrSt.executeUpdate();
        /** Сompletion */
        try {
            colorsPrSt = connection.prepareStatement("INSERT INTO colors (color) VALUES ('GREEN')");
            colorsPrSt.executeUpdate();

            colorsPrSt = connection.prepareStatement("INSERT INTO colors (color) VALUES ('RED')");
            colorsPrSt.executeUpdate();

            colorsPrSt = connection.prepareStatement("INSERT INTO colors (color) VALUES ('BLUE')");
            colorsPrSt.executeUpdate();

            colorsPrSt = connection.prepareStatement("INSERT INTO colors (color) VALUES ('WHITE')");
            colorsPrSt.executeUpdate();

            colorsPrSt = connection.prepareStatement("INSERT INTO colors (color) VALUES ('BROWN')");
            colorsPrSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Таблица уже сolors заполнена");
        }
    }
    private void createTypesTable() throws SQLException {
        /** Creating */
        PreparedStatement typesPrSt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS types(" +
                        "type VARCHAR PRIMARY KEY NOT NULL)");

        /** Сompletion */
        try {
            typesPrSt = connection.prepareStatement("INSERT INTO types (type) VALUES ('WATER')");
            typesPrSt.executeUpdate();

            typesPrSt = connection.prepareStatement("INSERT INTO types (type) VALUES ('UNDERGROUND')");
            typesPrSt.executeUpdate();

            typesPrSt = connection.prepareStatement("INSERT INTO types (type) VALUES ('AIR')");
            typesPrSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Таблица уже types заполнена");
        }
    }
    private void createCharactersTable() throws SQLException {
        /** Creating */
        PreparedStatement charactersPrSt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS characters(" +
                        "character VARCHAR PRIMARY KEY NOT NULL)");

        /** Сompletion */
        try {
            charactersPrSt = connection.prepareStatement("INSERT INTO characters (character) VALUES ('CUNNING')");
            charactersPrSt.executeUpdate();

            charactersPrSt = connection.prepareStatement("INSERT INTO characters (character) VALUES ('WISE')");
            charactersPrSt.executeUpdate();

            charactersPrSt = connection.prepareStatement("INSERT INTO characters (character) VALUES ('EVIL')");
            charactersPrSt.executeUpdate();

            charactersPrSt = connection.prepareStatement("INSERT INTO characters (character) VALUES ('FICKLE')");
            charactersPrSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Таблица уже сharacters заполнена");
        }
    }
    private void createDragonsTable() throws SQLException {
        PreparedStatement dragonsPrSt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS dragons(" +
                        "ID BIGSERIAL PRIMARY KEY," +
                        "name VARCHAR NOT NULL," +
                        "coord_x BIGINT NOT NULL," +
                        "coord_y FLOAT NOT NULL CHECK (coord_y <= 508)," +
                        "creationDate TIMESTAMP NOT NULL," +
                        "age BIGINT CHECK (age > 0) NOT NULL," +
                        "color VARCHAR REFERENCES colors (color) NOT NULL," +
                        "type VARCHAR REFERENCES types (type) NOT NULL," +
                        "character VARCHAR REFERENCES characters (character) NOT NULL," +
                        "head_size BIGINT NOT NULL," +
                        "head_eyesCount BIGINT NOT NULL," +
                        "head_toothCount BIGINT," +
                        "userID BIGINT REFERENCES users (ID) NOT NULL)");
        dragonsPrSt.executeUpdate();
    }

    /** password hashing */
    private String getHash( String sequence ) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update("Pupock".getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest(sequence.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.err.println("Не захешировать пароль:");
            throw new RuntimeException(e);
        }
    }

    /** for users */
    public void registerUser( String login, String password ) {
        try {
            connectionToDB();
            PreparedStatement usersPrSt = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?)");
            usersPrSt.setString(1, login);
            usersPrSt.setString(2, getHash(password));
            usersPrSt.execute();
        } catch (SQLException e) {
            System.err.println("Не удалось добавить пользователя:");
            e.printStackTrace();
        }
    }
    public boolean userIsExist(String login) {
        try {
            connectionToDB();
            PreparedStatement usersPrSt = connection.prepareStatement("SELECT FROM users WHERE login = ?");
            usersPrSt.setString(1, login);
            return usersPrSt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkPassword(String login, String password) {
        try {
            connectionToDB();
            PreparedStatement usersPrSt = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            usersPrSt.setString(1, login);
            usersPrSt.setString(2, getHash(password));
            return usersPrSt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private int getUserID( String login, String password ) {
        try {
            connectionToDB();
            PreparedStatement usersPrSt = connection.prepareStatement("SELECT ID FROM users WHERE login = ? AND password = ?");
            usersPrSt.setString(1, login);
            usersPrSt.setString(2, getHash(password));
            ResultSet resultSet = usersPrSt.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean checkCreator( int dragonID, String login, String password ) {
        try {
            connectionToDB();
            PreparedStatement checkPrSt = connection.prepareStatement("SELECT FROM dragons WHERE ID = ? AND UserID = ?");
            checkPrSt.setInt(1, dragonID);
            checkPrSt.setInt(2, getUserID(login, password));
            return checkPrSt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Dragon> getElements() {
        ArrayList<Dragon> data = new ArrayList<Dragon>();
        try {
            connectionToDB();
            PreparedStatement dataPrSt = connection.prepareStatement(
                    "SELECT * FROM dragons");
            ResultSet resultSet = dataPrSt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                Coordinates coord = new Coordinates(resultSet.getInt("coord_x"), resultSet.getFloat("coord_y"));
                LocalDateTime creationDate = resultSet.getObject("creationDate", LocalDateTime.class);
                int age = resultSet.getInt("age");
                Color color = Color.valueOf(resultSet.getString("color"));
                DragonType type = DragonType.valueOf(resultSet.getString("type"));
                DragonCharacter character = DragonCharacter.valueOf(resultSet.getString("character"));
                DragonHead head = new DragonHead(resultSet.getInt("head_size"), resultSet.getLong("head_eyesCount"), resultSet.getLong("head_toothCount"));
                data.add(new Dragon(id, name, coord, creationDate, age, color, type, character, head));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public java.time.LocalDateTime getDBCreationTime() {
        try {
            connectionToDB();
            PreparedStatement dataPrSt = connection.prepareStatement("SELECT MIN(creationDate) FROM dragons");
            ResultSet resultSet = dataPrSt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getObject(1, LocalDateTime.class);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int addElement( Dragon newDragon, String login, String password ) {
        try {
            connectionToDB();

            PreparedStatement addPrSt = connection.prepareStatement(
                    "INSERT INTO dragons (name, coord_x, coord_y, creationDate, age, color, type, character, head_size, head_eyesCount, head_toothCount, userID)\n" +
                            "VALUES (?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?)");
            addPrSt.setString(1, newDragon.getName());
            addPrSt.setInt(2, newDragon.getCoordinates().getXCoordinate());
            addPrSt.setFloat(3, newDragon.getCoordinates().getYCoordinate());
            //preparedStatement.setObject(4, newDragon.getCreationDate());
            addPrSt.setInt(4, newDragon.getAge());
            addPrSt.setString(5, newDragon.getColor().toString());
            addPrSt.setString(6, newDragon.getType().toString());
            addPrSt.setString(7, newDragon.getCharacter().toString());
            addPrSt.setInt(8, newDragon.getHead().getSize());
            addPrSt.setLong(9, newDragon.getHead().getEyesCount());
            addPrSt.setLong(10, newDragon.getHead().getToothCount());
            addPrSt.setInt(11, getUserID(login, password));

            System.out.println(getUserID(login, password));

            return addPrSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    public boolean updateElementById( Dragon newDragon, int id, String login, String password ) {
        try {
            connectionToDB();
            PreparedStatement updatePrSt = connection.prepareStatement(
                    "UPDATE dragons SET (name, coord_x, coord_y, age, color, type, character, head_size, head_eyesCount, head_toothCount)" +
                            "= (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE userID = ? AND ID = ?");

            updatePrSt.setString(1, newDragon.getName());
            updatePrSt.setInt(2, newDragon.getCoordinates().getXCoordinate());
            updatePrSt.setFloat(3, newDragon.getCoordinates().getYCoordinate());
            updatePrSt.setInt(4, newDragon.getAge());
            updatePrSt.setString(5, newDragon.getColor().toString());
            updatePrSt.setString(6, newDragon.getType().toString());
            updatePrSt.setString(7, newDragon.getCharacter().toString());
            updatePrSt.setInt(8, newDragon.getHead().getSize());
            updatePrSt.setLong(9, newDragon.getHead().getEyesCount());
            updatePrSt.setLong(10, newDragon.getHead().getToothCount());
            updatePrSt.setInt(11, getUserID(login, password));
            updatePrSt.setInt(12, id);

            return updatePrSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean removeElementById( int id, String login, String password ) {
        try {
            connectionToDB();
            PreparedStatement removePrSt = connection.prepareStatement("DELETE FROM dragons WHERE userId = ? AND Id = ?");
            removePrSt.setInt(1, getUserID(login, password));
            removePrSt.setInt(2, id);

            return removePrSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean ClearCollection( String login, String password ) {
        try {
            connectionToDB();
            PreparedStatement ClearPrSt = connection.prepareStatement("DELETE FROM dragons WHERE userID = ?");
            ClearPrSt.setInt(1, getUserID(login, password));
            return ClearPrSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
