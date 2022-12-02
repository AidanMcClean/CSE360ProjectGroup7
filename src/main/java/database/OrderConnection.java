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
            ps.close();
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public static void updateStatus(String cookStatus, int PizzaNumber){
        final String SQL = "UPDATE PizzaOrder SET cookStatus = ? WHERE PizzaNumber =?";
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

    public static void updateAStatus(boolean acceptedStatus, int PizzaNumber){
        final String SQL = "UPDATE PizzaOrder SET acceptedStatus = ? WHERE PizzaNumber =?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
            ps.setBoolean(1, acceptedStatus);
            ps.setInt(2, PizzaNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public static void PrintDB() {
        String sql = "SELECT mushroom, onion, pizzatype FROM PizzaOrder"; //changable method to test stuff

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getBoolean("mushroom") + "\t" +
                        rs.getBoolean("onion") + "\t" +
                        rs.getInt("pizzatype"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int PizzaType(int PizzaNumber) {
        String sql = "SELECT pizzatype FROM PizzaOrder WHERE PizzaNumber =?" ; //changable method to test stuff
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            int a = 5;
            ps.setInt(1, PizzaNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt("pizzatype");
            }
            return a;


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return 5;
    }

    public static String PizzaTime(int PizzaNumber) {
        String sql = "SELECT pickuptime FROM PizzaOrder WHERE PizzaNumber =?" ;
        String a = " ";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, PizzaNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("pickuptime");
            }
            return a;


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return a;
    }

    public static String PizzaToppings(int PizzaNumber) {
        String sql = "SELECT mushroom, onion, olives, extraCheese FROM PizzaOrder WHERE PizzaNumber =?" ; //changable method to test stuff
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
           String toppings = "";
            boolean m = false, on = false, ol = false, eC = false;
            ps.setInt(1, PizzaNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = rs.getBoolean("mushroom");
                on = rs.getBoolean("onion");
                ol = rs.getBoolean("olives");
                eC = rs.getBoolean("extraCheese");
            }
            if(m == true){
                toppings+= "mushroom";
            }
            if(on == true){
                toppings+= " onion";
            }
            if(ol == true){
                toppings+= " olives";
            }
            if(eC == true){
                toppings+= " extraCheese";
            }
            return toppings;


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return "hi";
    }

    public static String PizzaStatus(int PizzaNumber) {
        String sql = "SELECT cookStatus FROM PizzaOrder WHERE PizzaNumber = ?" ; //changable method to test stuff
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            String m = " ";
            ps.setInt(1, PizzaNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = rs.getString("cookStatus");
            }

            return m;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return "unlucky";
    }

    public static Boolean acceptedStatus(int PizzaNumber) {
        String sql = "SELECT acceptedStatus FROM PizzaOrder WHERE PizzaNumber = ?" ;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            Boolean m = false;
            ps.setInt(1, PizzaNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = rs.getBoolean("acceptedStatus");
            }

            return m;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static int getMax(){
        String sql = "SELECT MAX(PizzaNumber) as max_pNum from PizzaOrder";
        int max = 0;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            // loop through the result set
            if (rs.next()) {
                max = rs.getInt("max_pNum");
            }
            return max;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return max;
    }

    public static int getMin(){
        String sql = "SELECT MIN(PizzaNumber) as min_pNum from PizzaOrder";
        int min = 0;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            // loop through the result set
            if (rs.next()) {
                min = rs.getInt("min_pNum");
            }
            return min;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return min;
    }

    public static void DeleteRow(int PizzaNumber){
        String sql = "DELETE FROM Table WHERE PizzaNumber = ?";
        int max = 0;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, PizzaNumber);
            ps.executeUpdate();


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

}
