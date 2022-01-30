/**
 * Loginform let usr to login using their username and password
 * @author Saugat Sharma
 * @version first
 * @bugs None.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class LoginForm extends JFrame {

    /*swing library attributes from loginForm*/
    private static boolean loginFrame = true;
    private JTextField userNameText;
    private JButton loginButton;
    private JButton cancelButton;
    private JButton signUpButton;
    private JPanel loginPanel;
    private JPasswordField passwordText;
    private SignUpForm signUpForm;


    /* === private attributes to store the name and usrename ===*/
    private String UserNameText;
    private String usrName;


    /**
     * Constructor for loginForm
     */
    public LoginForm(){

        /*loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);*/

        /**
         * @about actionListener activated when the user click the Login Button
         */
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean isTrue = false;

                //getting the information from the user input and storing in private defined attributes
                UserNameText = userNameText.getText();
                char[] PasswordText = passwordText.getPassword();


                /*checking if the userName/password is empty*/
                if(UserNameText.length() > 0 && PasswordText.length> 0){

                    /* == SQL query to select the given variable from the sql database == */
                    String query = "SELECT username, password, firstname, middlename, lastname FROM signUpTable";

                    /*using try/catch to validate the connection to the SQL server, Using JDBC queries*/
                    try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Bug Report", "root", "password")){
                        Statement statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        /*using while statement to get all the information of given variable from the database*/
                        while (resultSet.next()){

                            /*storing the value in local variables*/
                            String name = null;
                            String uName = resultSet.getString("username");
                            String password = resultSet.getString("password");
                            String firstName = resultSet.getString("firstname");
                            String middleName = resultSet.getString("middlename");
                            String lastname = resultSet.getString("lastname");

                            /*checking if the username and password matches from the information in database*/
                            if((UserNameText.equals(uName))&& (String.valueOf(PasswordText).equals(password))){

                                /*checking if the middlename if empty*/
                                if(Objects.equals(middleName, "null")){
                                    name = resultSet.getString("firstname") + " " + resultSet.getString("lastname");
                                    setUsrName(name);
                                }else{
                                    name = resultSet.getString("firstname") + " " + resultSet.getString("middlename") +" " +  resultSet.getString("lastname");
                                    setUsrName(name);
                                }
                                isTrue = true;
                            }
                        }

                        //If user name and password matches then performs the following action
                        if(isTrue){
                            //hides the login panel
                            loginPanel.setVisible(false);

                            /*calling dashboard panel*/
                            JFrame frame = new JFrame("DashBoard");
                            frame.setContentPane(new DashBoard(getUserNameText()).getDashBoardPanel());
                            frame.setLocationRelativeTo(null);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.pack();
                            frame.setVisible(true);
                        }
                        //System.out.println(isTrue);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


            }
        });


        /**
         * actionListener activated when user clicks the signUp button
         */
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                loginFrame = false;
                //calls the signup form
                JFrame frame = new JFrame("SignUp Form");
                frame.setContentPane(new SignUpForm().getSignupPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);


            }
        });
        /*ActionListener activated when user clickes the cancel button*/
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }


    /* ==== all the getter and setters for the attributes defined above ====*/
    public void setUserNameText(String userNameText) {
        UserNameText = userNameText;
    }

    public String getUserNameText() {
        return UserNameText;
    }


    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrName() {
        return usrName;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        JLabel pic = new JLabel(new ImageIcon("images.png"));
        frame.setContentPane(new LoginForm().loginPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(loginFrame);
    }
}
