import java.sql.*;

public class main {


    public static void main(String [] args){
        String name = "Saugat";
        int num = 4;
        String User_Input = "INSERT INTO test (ID, name)" + " VALUES (?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Bug Report", "root", "password")) {
            Statement statement = connection.createStatement();

            if(connection != null){
                System.out.println("Connected to the database\n");
            }
            PreparedStatement preparedStatement = statement.getConnection().prepareStatement(User_Input);
            preparedStatement.setString(1, String.valueOf(num));
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();

            ResultSet resultSet = statement.executeQuery("select * from test");

            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
