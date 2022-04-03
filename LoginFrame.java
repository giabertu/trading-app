import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import view.PanelButton;

public class LoginFrame extends JFrame {

    public JTextField usernameField;
    public JTextField pwField;
    public PanelButton submitButton;

    public LoginFrame(){

        this.setSize(400, 400);
        addAllButtonsAndFields();
        this.setLayout(null);
        this.setVisible(true);
    }

    public void addAllButtonsAndFields(){
        submitButton = new PanelButton(150, 300, 100, 50);
        submitButton.setText("Create Account");
        this.add(submitButton);
    }

    public void addSubmitActionListener(ActionListener e){
        submitButton.addActionListener(e);
    }
}
