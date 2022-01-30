
/**
 * SignUp form that lets user input their information .
 * @author Saugat Sharma
 * @version first
 * @bugs None.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;

public class SignUpForm extends JFrame{

    /*swing libarary attribute from the form*/
    private JComboBox titleConboBox;
    private JTextField firstnameText;
    private JTextField middlenameText;
    private JTextField lastnameText;
    private JTextField emailText;
    private JTextField userNameText;
    private JTextField workphoneText;
    private JTextField homephoneText;
    private JTextField addressText;
    private JTextField address2Text;
    private JTextField cityText;
    private JTextField stateText;
    private JTextField zipText;
    private JButton submitButton;
    private JPasswordField passwordText;
    private JPasswordField conformpasswordText;
    private JPanel signupPanel;
    private JTextField countryText;


    //private attributes to store the information
    private boolean isError = false;
    private String TitleBox;
    private String firstNameBox;
    private String MiddleNameBox;
    private String LastNameText;
    private String EmailText;
    private String UserNameText;
    private String WorkPhoneText;
    private String HomePhoneText;
    private String Address1Text;
    private String Address2Text;
    private String City;
    private String State;
    private String Zip;
    private String CountryText;
    private char[] PasswordText;
    private char[] ConformPasswordText;


    /**
     * Signup form constructor
     */
    public SignUpForm(){

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setTitleBox((String) titleConboBox.getSelectedItem());
                System.out.println(getTitleBox());

                //setting up the setter for all the forms
                if(firstnameText.getText().isEmpty()){
                    setFirstNameBox("null");
                }else {
                    setFirstNameBox(firstnameText.getText());
                }

                if(middlenameText.getText().isEmpty()){
                    setMiddleNameBox("null");
                }else{
                    setMiddleNameBox(middlenameText.getText());
                }

                if(lastnameText.getText().isEmpty()){
                    setLastNameText("null");
                }else{
                    setLastNameText( lastnameText.getText());
                }

                if(emailText.getText().isEmpty()){
                    setEmailText("null");
                }else{
                    setEmailText(emailText.getText());
                }

                if(userNameText.getText().isEmpty()){
                    setUserNameText("null");
                }else{
                    setUserNameText(userNameText.getText());
                }

                if(workphoneText.getText().isEmpty()){
                    setWorkPhoneText("null");
                }else{
                    setWorkPhoneText(workphoneText.getText());
                }

                if (homephoneText.getText().isEmpty()){
                    setHomePhoneText("null");
                }else{
                    setHomePhoneText(homephoneText.getText());
                }
                if(addressText.getText().isEmpty()){
                    setAddress1Text("null");
                }else{
                    setAddress1Text(addressText.getText());
                }

                if(address2Text.getText().isEmpty()){
                    setAddress2Text("null");
                }else{
                    setAddress2Text(address2Text.getText());
                }

                if(cityText.getText().isEmpty()){
                    setCity("null");
                }else{
                    setCity(cityText.getText());
                }

                if(stateText.getText().isEmpty()){
                    setState("null");
                }else{
                    setState(stateText.getText());
                }

                if(zipText.getText().isEmpty()){
                    setZip("null");
                }else{
                    setZip( zipText.getText());
                }
                if(countryText.getText().isEmpty()){
                    setCountryText("null");
                }else {
                    setCountryText(countryText.getText());
                }

                /*System.out.println(getFirstNameBox());
                System.out.println(getMiddleNameBox());
                System.out.println(getLastNameText());
                System.out.println(getEmailText());
                System.out.println(getUserNameText());
                System.out.println(getWorkPhoneText());
                System.out.println(getHomePhoneText());
                System.out.println(getAddress1Text());
                System.out.println(getAddress2Text());
                System.out.println(getCity());
                System.out.println(getStateBox());
                System.out.println(getZip());
                System.out.println(getConformPasswordText());
                System.out.println(getCountryText());
                System.out.println(getPasswordText());*/

                setPasswordText(passwordText.getPassword());
                setConformPasswordText(conformpasswordText.getPassword());

                //checking if the title box is empty
                if(getTitleBox().equals("Select Title")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter Title");
                    isError = true;

                }
                //checking if the first name is empty
                if (getFirstNameBox().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter your First Name");
                }

                //checking if the last name is empty
                if (getLastNameText().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter your Last Name");
                    isError = true;
                }

                //checking if the email is empty
                if(getEmailText().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter valid Email");
                    isError = true;

                }else{
                    //validating the email
                    String emRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

                    Pattern pattern = Pattern.compile(emRegex);
                    boolean isValid = pattern.matcher(getEmailText()).matches();
                    if(!isValid){
                        JOptionPane.showMessageDialog(signupPanel, "Please enter valid Email");
                        isError = true;
                    }
                }

                //checking if the username is empty
                if(getUserNameText().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter your UserName");
                    isError = true;

                }

                //checking if the phone is empty
                if(getWorkPhoneText().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter WorkPhone");
                    isError = true;

                }else{
                    try {
                        //checking if the user input is integer
                        Double.parseDouble(getWorkPhoneText());
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(signupPanel, "Work phone should be integer");
                        isError = true;
                    }
                }

                if(getAddress1Text().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter your Address");
                    isError = true;

                }


                if(getCity().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter your City");
                    isError = true;

                }
                if(getStateBox().equals("null")){

                    JOptionPane.showMessageDialog(signupPanel, "Please enter your State");
                    isError = true;
                }

                if(getZip().equals("null")){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter your Zip");
                    isError = true;

                }else{
                    try {
                        //checking if the user input is integer
                        Double.parseDouble(getZip());
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(signupPanel, "Zip should be integer");
                        isError = true;
                    }
                }

                if(passwordText.getPassword().equals(null)){
                    JOptionPane.showMessageDialog(signupPanel, "Please enter password");
                    isError = true;
                }else{

                    //getting the length of password provided
                    int length1 = passwordText.getPassword().length;
                    int length2 = conformpasswordText.getPassword().length;

                    if(length1 == length2){

                        //this checks if the password and conform password are same
                        for (int i= 0; i<=length1-1; i++){
                            if(passwordText.getPassword()[i] != conformpasswordText.getPassword()[i]){
                                JOptionPane.showMessageDialog(signupPanel, "Password does not match");
                                isError = true;
                                break;
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(signupPanel, "Password does not match");
                        isError = true;
                    }
                }
                if(getCountryText().equals("null")){
                        JOptionPane.showMessageDialog(signupPanel, "Please enter your Country");
                        isError = true;

                }




                /* === SQL query to  insert all the information in the SQL database ===*/
                String User_Input = "INSERT INTO signUpTable (title,firstname, middlename, lastname, email, username, password, workphone, homephone, address1, address2, city, state, zip, country)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Bug Report", "root", "password")) {
                    Statement statement = connection.createStatement();

                    if(connection != null){
                        System.out.println("Connected to the database\n");
                    }
                    if(!isError){

                        /* === JDBC query to run SQL query ===*/
                        PreparedStatement preparedStatement = connection.prepareStatement(User_Input);
                        preparedStatement.setString(1, getTitleBox());
                        preparedStatement.setString(2, getFirstNameBox());
                        preparedStatement.setString(3, getMiddleNameBox());
                        preparedStatement.setString(4, getLastNameText());
                        preparedStatement.setString(5, getEmailText());
                        preparedStatement.setString(6, getUserNameText());
                        preparedStatement.setString(7, String.valueOf(getPasswordText()));
                        preparedStatement.setString(8, getWorkPhoneText());
                        preparedStatement.setString(9, getHomePhoneText());
                        preparedStatement.setString(10, getAddress1Text());
                        preparedStatement.setString(11, getAddress2Text());
                        preparedStatement.setString(12, getCity());
                        preparedStatement.setString(13, getStateBox());
                        preparedStatement.setString(14, getZip());
                        preparedStatement.setString(15, getCountryText());
                        preparedStatement.executeUpdate();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }


    /**
     * All the getters and setters for the attributes
     */

    public JPanel getSignupPanel() {
        return signupPanel;
    }

    public String getTitleBox() {
        return TitleBox;
    }

    public String getFirstNameBox() {
        return firstNameBox;
    }

    public String getMiddleNameBox() {
        return MiddleNameBox;
    }

    public String getLastNameText() {
        return LastNameText;
    }

    public String getEmailText() {
        return EmailText;
    }

    public String getUserNameText() {
        return UserNameText;
    }

    public String getWorkPhoneText() {
        return WorkPhoneText;
    }

    public String getHomePhoneText() {
        return HomePhoneText;
    }

    public String getAddress1Text() {
        return Address1Text;
    }

    public String getAddress2Text() {
        return Address2Text;
    }

    public String getCity() {
        return City;
    }


    public String getZip() {
        return Zip;
    }

    public String getStateBox(){
        return State;
    }
    public char[] getPasswordText() {
        return PasswordText;
    }

    public char[] getConformPasswordText() {
        return ConformPasswordText;
    }

    public void setTitleBox(String titleBox) {
        TitleBox = titleBox;
    }

    public void setFirstNameBox(String firstNameBox) {
        this.firstNameBox = firstNameBox;
    }

    public void setMiddleNameBox(String middleNameBox) {
        MiddleNameBox = middleNameBox;
    }

    public void setLastNameText(String lastNameText) {
        LastNameText = lastNameText;
    }

    public void setEmailText(String emailText) {
        EmailText = emailText;
    }

    public void setUserNameText(String userNameText) {
        UserNameText = userNameText;
    }

    public void setWorkPhoneText(String workPhoneText) {
        WorkPhoneText = workPhoneText;
    }

    public void setHomePhoneText(String homePhoneText) {
        HomePhoneText = homePhoneText;
    }

    public void setAddress1Text(String address1Text) {
        Address1Text = address1Text;
    }

    public void setAddress2Text(String address2Text) {
        Address2Text = address2Text;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setState(String state) {
        State = state;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public void setPasswordText(char[] passwordText) {
        PasswordText = passwordText;
    }

    public void setConformPasswordText(char[] conformPasswordText) {
        ConformPasswordText = conformPasswordText;
    }


    public String getCountryText() {
        return CountryText;
    }

    public void setCountryText(String countryText) {
        CountryText = countryText;
    }


    /*public static void main(String[] args) {
        JFrame frame = new JFrame("SignUp Form");
        frame.setContentPane(new SignUpForm().signupPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }*/
}
