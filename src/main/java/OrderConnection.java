import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OrderConnection
{
    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:OrderData.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists PizzaOrder");

            statement.executeUpdate("CREATE TABLE PizzaOrder (PizzaNumber int NOT NULL, asuID varchar(255) NOT NULL, pizzatype int, mushroom boolean, onion boolean, olives boolean, extraCheese boolean, pickuptime varchar(5), acceptedStatus boolean, cookStatus varchar(255), PRIMARY KEY (PizzaNumber))");

            statement.executeUpdate("INSERT INTO PizzaOrder VALUES(1, 1, 1, 1,1,1,1,'hi',1,'hi')");

        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}