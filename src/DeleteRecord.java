/**
 * DeleteRecord form let user search the bug information from their title and lets user delete them
 * @author Saugat Sharma
 * @version first
 * @bugs None.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRecord extends JFrame{
    private JTextField textField1;
    private JButton deleteButton;


    private JPanel deletePanel;

    public DeleteRecord() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public JPanel getDeletePanel() {
        return deletePanel;
    }

}
