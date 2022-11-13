import java.sql.*;


public class OrderConnection {
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
    public static void insertOrder(int PizzaNumber, String asuID, int pizzaType, boolean mushroom, boolean onion, boolean olives, boolean extraCheese, String pickupTime, boolean acceptedStatus, String cookStatus){
        final String SQL = "INSERT INTO PizzaOrder VALUES(?, ? ,? ,? ,? ,? ,? ,? ,? ,?)";
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:OrderData.db"); PreparedStatement ps = con.prepareStatement(SQL);){
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
        }catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }
}