import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    private JTextField textField1;
    private JButton findButton;
    private JPanel mainPanel;
    private JList<String> list1;
    private JButton followButton;

    private String tag;

    public Frame () {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tag = textField1.getText();
            }
        });

        followButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

}
