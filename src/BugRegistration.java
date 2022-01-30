/**
 * Bug Registration form let user to input the bug information and stores them in the SQL database.
 * @author Saugat Sharma
 * @version first
 * @bugs None.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class BugRegistration extends JFrame{


    /* === Swing library attributes for BugRegistration.form*/
    private JPanel bugTrackerForm;
    private JTextField titleText;
    private JRadioButton bugRadioButton;
    private JRadioButton featureRadioButton;
    private JCheckBox googleChromeCheckBox;
    private JCheckBox fireFoxCheckBox;
    private JCheckBox internetExplorerCheckBox;
    private JCheckBox operaCheckBox;
    private JCheckBox safariCheckBox;
    private JCheckBox netscapeCheckBox;
    private JCheckBox otherCheckBox;
    private JTextArea descriptionTextArea;
    private JTextArea stepsTextArea;
    private JButton attachFileButton;
    private JButton submitFormButton;
    private JLabel registerBugLabel;
    private JLabel titleLabel;
    private JLabel typeLabel;
    private JComboBox priorityComboBox;


    /*attributes to store the information obtained from the Front-end of Bug registration form*/
    private String DescriptionText;
    private String StepText;
    private String bugType;
    private String browserType;
    private String TitleText;
    private String Priority;
    private String name;
    private FileReader fileReader;
    private File file;
    private JFileChooser jFileChooser = new JFileChooser();
    private LoginForm loginForm  = new LoginForm();


    /**
     * BugResistration constructor
     */
    public BugRegistration(){

        /*gets the client name from the login page getUserName attribute*/
        this.setName(loginForm.getUsrName());

        /**
         * Actionlistener activated when the usre clicks submit button
         * */
        submitFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //using setter to set the information
                setTitleText(titleText.getText());
                setDescriptionText(descriptionTextArea.getText());
                setStepText(stepsTextArea.getText());
                setPriority((String) priorityComboBox.getSelectedItem());

                /*Checking the check box that user has selected*/
                if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Opera, Internet Explorer, Netscape, Safari, Other");

                } else if (fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("FireFox, Opera, Internet Explorer, Netscape, Safari, Other");

                } else if (operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("FireFox, Opera, Internet Explorer, Netscape, Safari, Other");

                }  else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Opera, Internet Explorer, Netscape, Safari");

                }else if (fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected()) {
                    setBrowserType("FireFox, Opera, Internet Explorer, Netscape, Safari");

                } else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Opera, Internet Explorer, Netscape");

                } else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Opera, Internet Explorer");

                } else if (fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected()) {
                    setBrowserType("FireFox, Opera, Internet Explorer, Netscape");

                } else if (operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected()) {
                    setBrowserType("Opera, Internet Explorer, Netscape, Safari");

                } else if (internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("Internet Explorer, Netscape, Safari, Other");

                } else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & operaCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Opera");

                }else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & internetExplorerCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Internet Explorer");

                }else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Other");

                }else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected() & safariCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox, Safari");

                }else if (internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() & safariCheckBox.isSelected()) {
                    setBrowserType("Internet Explorer, Netscape, Safari");

                } else if (fireFoxCheckBox.isSelected() & operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected()) {
                    setBrowserType("FireFox, Opera, Internet Explorer");

                } else if ( netscapeCheckBox.isSelected() & safariCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("Netscape, Safari, Other");

                } else if (operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() ) {
                    setBrowserType("Opera, Internet Explorer, Netscape");

                } else if (googleChromeCheckBox.isSelected() & fireFoxCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome, FireFox");

                } else if (operaCheckBox.isSelected() & internetExplorerCheckBox.isSelected()) {
                    setBrowserType("Opera, Internet Explorer");

                } else if (fireFoxCheckBox.isSelected() & operaCheckBox.isSelected()) {
                    setBrowserType("FireFox. Opera");

                } else if ( netscapeCheckBox.isSelected() & safariCheckBox.isSelected()) {
                    setBrowserType("Netscape, Safari");

                } else if (internetExplorerCheckBox.isSelected() & netscapeCheckBox.isSelected() ) {
                    setBrowserType("Internet Explorer, Netscape");

                }  else  if (safariCheckBox.isSelected() & otherCheckBox.isSelected()) {
                    setBrowserType("Safari, Other");

                } else if (googleChromeCheckBox.isSelected()) {
                    setBrowserType("GoogleChrome");

                } else if (fireFoxCheckBox.isSelected()) {
                    setBrowserType("FireFox");

                }else if (internetExplorerCheckBox.isSelected() ) {
                    setBrowserType("Internet Explorer");

                }  else  if (safariCheckBox.isSelected()) {
                    setBrowserType("Safari");

                } else if (operaCheckBox.isSelected()) {
                    setBrowserType("Opera");

                }  else if ( netscapeCheckBox.isSelected()) {
                    setBrowserType("Netscape");

                } else if (otherCheckBox.isSelected()) {
                    setBrowserType("Other");

                }else {
                    setBrowserType("Null");

                }

                /*System.out.println(getTitleText());
                System.out.println(getBugType());
                System.out.println(getPriority());
                System.out.println(getBrowserType());
                System.out.println(getDescriptionText());
                System.out.println(getStepText());*/

                /* ==== SQL STATEMENT TO INSERT INTO THE FORM ==== */
                String User_Input = "INSERT INTO BugRegistration (Title,Type,BrowserType,PriorityType,Description,StepToProduce,AttachFile)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

                /* ==== Using try/catch for error check during connection to sql server ==== */
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Bug Report", "root", "password")) {
                    Statement statement = connection.createStatement();

                    /*checking if the connection is successful*/
                    if(connection != null){
                        System.out.println("Connected to the database\n");
                    }

                    /*=== JDBC query that helps to insert the values into the sql database ====*/
                    PreparedStatement preparedStatement = connection.prepareStatement(User_Input);
                    preparedStatement.setString(1, getTitleText());
                    preparedStatement.setString(2, getBugType());
                    preparedStatement.setString(3, getBrowserType());
                    preparedStatement.setString(4, getPriority());
                    preparedStatement.setString(5, getDescriptionText());
                    preparedStatement.setString(6, getStepText());
                    preparedStatement.setCharacterStream(7, fileReader, file.length());
                    preparedStatement.executeUpdate();
                    fileReader.close();

                    //Output the result
                    //ResultSet resultSet = statement.executeQuery("select * from BugRegistration");

                    /*while(resultSet.next()){
                        System.out.println(resultSet.getString("Title"));
                    }*/
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        /**
         * @brief actionlistener activated when the user clicks the attack file button
         */
        attachFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                /*==== file input===*/
                jFileChooser.setDialogTitle("Save File");
                int result = jFileChooser.showSaveDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {

                    file = jFileChooser.getSelectedFile();
                    try {
                        fileReader = new FileReader(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        /**
         * @brief actionlistener activated when user clicks the Bug Type radio button
         */
        bugRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(bugRadioButton.isSelected()){
                    setBugType("Bug");
                    featureRadioButton.setSelected(false);
                }

            }
        });
        featureRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (featureRadioButton.isSelected()){
                    setBugType("FEATURE");
                    bugRadioButton.setSelected(false);
                }

            }
        });
    }


    /*all the getter and setter for the attributes*/
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public JPanel getBugTrackerForm() {
        return bugTrackerForm;
    }

    public String getTitleText() {
        return TitleText;
    }

    public String getDescriptionText() {
        return DescriptionText;
    }

    public String getStepText() {
        return StepText;
    }

    public String getBugType() {
        return bugType;
    }


    public String getPriority() {
        return Priority;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setTitleText(String titleText){
        TitleText= titleText;
    }

    public void setDescriptionText(String descriptionText) {
        DescriptionText = descriptionText;
    }

    public void setStepText(String stepText) {
        StepText = stepText;
    }
    public void setBugType(String bugType) {
        this.bugType = bugType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("BugRegistration");
        frame.setContentPane(new BugRegistration().bugTrackerForm);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
