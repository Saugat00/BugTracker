
/**
 * Dashboard for a Bug tracker software that connects to other feature of the software.
 * @author Saugat Sharma
 * @version first
 * @bugs None.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame{
    private JButton searchRecordButton;
    private JButton peopleButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton helpButton;
    private JButton chatButton;
    private JPanel dashBoardPanel;
    private String name;
    private JPanel menuPanel;
    private JLabel searchPanel;
    private JTextField searchHere;

    public DashBoard(String name) {
        this.name = name;

        /**
         * Action Listener is a feature which connect fornt end with the back end of the software
         * @brief this action Listener is activated when the user in the front end clicks the search button
         */
        searchRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        /**
         * @brief this action Listener is activated when the user in the front end clicks the people button in the menu
         */
        peopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        /**
         * @brief  this actionlistener is activated when the user in the frontend clicks the insert Button
         */
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*call the bugRegistration form*/
                JFrame frame = new JFrame("BugRegistration");
                frame.setContentPane(new BugRegistration().getBugTrackerForm());
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        /**
         * @brief this actionlistener is activated when the user clicks the delete button
         */
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*hidesthe dashboard panel*/
                dashBoardPanel.setVisible(false);
                JFrame frame = new JFrame("DeleteRecord");

                /*calling the delete record Panel*/
                frame.setContentPane(new DeleteRecord().getDeletePanel());
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });

        /**
         * @brief this actionlistener is activated when the user in the frond end clicks the chat button
         */
        chatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        /**
         * @brief this actionlistener is activated when the user in the frond end clicks the help Button
         */
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }


    /**
     * getter that gets the Dashboard panal private attribute
     * @return dashboard pannel
     */
    public JPanel getDashBoardPanel() {
        return dashBoardPanel;
    }

    /**
     * getter that gets the name of the Client
     * @return name of the client
     */
    @Override
    public String getName() {
        return name;
    }
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("DashBoard");
        frame.setContentPane(new DashBoard().dashBoardPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
}
