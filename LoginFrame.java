import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import view.FramePanel;
import view.PanelButton;

public class LoginFrame extends JFrame {

    public JTextField usernameField;
    public JTextField pwField;
    public PanelButton submitButton;

    public LoginFrame(){

        this.setSize(400, 400);
        addAllButtonsAndFields();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void addAllButtonsAndFields(){
        FramePanel panel = new FramePanel(Color.WHITE, 0, 0, 400, 400);
        this.add(panel);
        submitButton = new PanelButton(150, 300, 100, 50);
        submitButton.setText("Create Account");
        panel.add(submitButton);
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(100, 50));
        usernameField.setText("username");
        panel.add(usernameField);
        pwField = new JTextField();
        pwField.setPreferredSize(new Dimension(100, 50));
        //pwField.setBounds(150, 250, 100, 50);
        pwField.setText("password"); 
        panel.add(pwField);
    }

    public void addSubmitActionListener(ActionListener e){
        submitButton.addActionListener(e);
    }
}
