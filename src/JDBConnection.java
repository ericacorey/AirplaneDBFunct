import java.sql.*;
import java.util.Scanner;

public class JDBConnection {
     public static void main(String[] args) {
        // AllTables();
        // ReadColumn();

        boolean run = true;

        while (run = true) {
            // runApp()
            // call a big method that calls other methods based on userinput
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose a function: 1.Display all tables; 2. ReadColumn; 3.Exit");
            int userInput = scanner.nextInt();
            switch(userInput) {
                case 1:
                    RunApp();
                    break;
                case 2:
                    ReadColumn();
                    break;
                default:
                    break;

            }

            }
            // if statement here
           // System.out.println("Your input was.." + userInput);// remove this line after putting if statement

        }



    public static void RunApp() {
        AllTables(false);
    }



    public static void ReadColumn() {


        try {

            // Line 20 is a custom based on your local database. Remove "airportdb" and
            // replace with the db that your using. Likewise, use the username and password
            // you used when setting up your database connection.

            // System.out.println("Connection Sucessful!.......");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root",
                    "taco");

            System.out.println("Connection Sucessful!.......");


            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from airport");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ApCountry"));
                System.out.println(resultSet.getString("ApCity"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void AllTables(boolean run) {
        try {
            run = false;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root",
                    "taco");

            System.out.println("Connection Sucessful!.......");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Show tables");
            System.out.println("Tables in the current database: ");
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");
    }

}
