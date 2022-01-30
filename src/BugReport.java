import javax.swing.*;
/**
 * Bug report gives the information of all the bug report that client has stored in sql
 * @author Saugat Sharma
 * @version first
 * @bugs None.
 */
public class BugReport extends JFrame{
    private JLabel nameLabel;
    private JLabel titleLabel;
    private JLabel userNameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JTable table1;
    private JPanel bugReportPanel;
    private LoginForm loginForm = new LoginForm();
    private String name;
    public BugReport(){
        this.name = loginForm.getUsrName();
        nameLabel.setText(name);


    }

    /**
     * getter that gets the bugReport form panel
     * @return bugReportPanel
     */
    public JPanel getBugReportPanel() {
        return bugReportPanel;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("BugReport");
        frame.setContentPane(new BugReport().bugReportPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
