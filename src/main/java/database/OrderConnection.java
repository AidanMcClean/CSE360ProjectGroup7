package database;

import java.sql.*;


public class OrderConnection {


    private static final String URL = "jdbc:sqlite:OrderData.db";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:OrderData.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists PizzaOrder");

            statement.executeUpdate("CREATE TABLE PizzaOrder (PizzaNumber int NOT NULL, asuID varchar(255) NOT NULL, pizzatype int, mushroom boolean, onion boolean, olives boolean, extraCheese boolean, pickuptime varchar(5), acceptedStatus boolean, cookStatus varchar(255), PRIMARY KEY (PizzaNumber))");


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public static void insertOrder(int PizzaNumber, String asuID, int pizzaType, boolean mushroom, boolean onion, boolean olives, boolean extraCheese, String pickupTime, boolean acceptedStatus, String cookStatus) {
        final String SQL = "INSERT INTO PizzaOrder VALUES(?, ? ,? ,? ,? ,? ,? ,? ,? ,?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
            ps.setInt(1, PizzaNumber);
            ps.setString(2, asuID);
            ps.setInt(3, pizzaType);
            ps.setBoolean(4, mushroom);
            ps.setBoolean(5, onion);
            ps.setBoolean(6, olives);
            ps.setBoolean(7, extraCheese);
            ps.setString(8, pickupTime);
            ps.setBoolean(9, acceptedStatus);
            ps.setString(10, cookStatus);
            ps.executeUpdate();
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public static void updateStatus(String cookStatus, int PizzaNumber){
        final String SQL = "UPDATE PizzaOrder SET cookStatus = ? WHERE asuID = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
            ps.setString(1, cookStatus);
            ps.setInt(2, PizzaNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public static void PrintDB() {
        String sql = "SELECT mushroom, PizzaType FROM PizzaOrder"; //changable method to test stuff

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getBoolean("mushroom") + "\t" +
                        rs.getInt("PizzaType"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int PizzaType(int PizzaNumber) {
        String sql = "SELECT PizzaType FROM PizzaOrder WHERE PizzaNumber = ?" ; //changable method to test stuff
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ps.setInt(1, PizzaNumber);
            ps.executeUpdate();
            return rs.getInt("PizzaType");


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return 5;
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

}
