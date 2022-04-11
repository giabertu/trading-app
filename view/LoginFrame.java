package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public JTextField usernameField;
    public JTextField pwField;
    public JButton submitButton;
    public AppFrame newFrame;

    public LoginFrame() {

        this.setTitle("Login Window");
        //this.setSize(400, 400);
        addAllButtonsAndFields();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(null);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public void addAllButtonsAndFields() {
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.WHITE);
        JLabel l = new JLabel("Username", JLabel.TRAILING);
        panel.add(l);
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(100,30));
        l.setLabelFor(usernameField);
        panel.add(usernameField);
        
        JLabel pw = new JLabel("Password", JLabel.TRAILING);
        panel.add(pw);
        pwField = new JTextField();
        pwField.setPreferredSize(new Dimension(100,30));
        pw.setLabelFor(pwField);
        panel.add(pwField);

        submitButton = new JButton();
        submitButton.setText("Login");
        panel.add(submitButton);
        this.add(panel);
    }

    public void addSubmitActionListener(ActionListener e) {
        submitButton.addActionListener(e);
    }
}
