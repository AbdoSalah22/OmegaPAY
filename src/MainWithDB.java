import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    public class MainWithDB {
        public static void main(String[] args) {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/omegapay2", "root", "123456789");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select  * from accounts");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name")
                            + " " + resultSet.getString("email")
                            + " " + resultSet.getDouble("balance")
                            + " " + resultSet.getString("cardnumber"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
