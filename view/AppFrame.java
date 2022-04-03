package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class AppFrame extends JFrame implements Frame {
    
    public PanelButton buttonDeposit;
    public PanelButton buttonWithdraw;
    public JTextField depositField;
    public JTextField withdrawField;
    public JMenuBar menuBar = new JMenuBar();

    public AppFrame() {

        this.setSize(900,700); //sets initial x and y dimension
        this.setTitle("Stock Trading App"); //gives a title to the frame (shown on top of it)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes sure that the app is killed
        //when you press on the close button, instead of hiding it.
        this.setIconImage(new ImageIcon("appIcon.png").getImage());
        this.getContentPane().setBackground(Color.lightGray); //change background color.
    
        this.setResizable(false); //this prevents the frame from being resized

        addAllPanels();
        addAllMenus();
        this.setLayout(null);

        //this.pack(); //sets the size of frame to accomodate all components. Make sure to add
        //All components before using pack. 
        this.setVisible(true); //make frame visible
    }

    @Override
    public FrameLabel addLabel(String title, int vertPos, int horPos){
        FrameLabel label = new FrameLabel(title, vertPos, horPos);
        this.add(label);
        return label;
    }

    @Override
    public FrameLabel addLabel(String title, int vertPos, int horPos, String icon){
        FrameLabel label = new FrameLabel(title, vertPos, horPos, icon);
        this.add(label);
        return label;
    }

    public void addAllLabels(){
       //this.addLabel("Portfolio", "portfolioIcon.png"); //note that if you set layout to null you wont see the label. 
    }


    //returns the panel, such that it is possible to add labels to individual panels.
    public FramePanel addPanel(Color color, int x, int y, int width, int height){
        FramePanel panel = new FramePanel(color, x, y, width, height);
        this.add(panel);
        return panel;
    }

    public PanelButton addButton(int x, int y, int width, int height){
        PanelButton button = new PanelButton(x, y, width, height);
        this.add(button);
        return button;
    }

    public void addAllButtons(){
        PanelButton button = addButton(200, 100, 100 , 50);
    }


    public void addAllPanels(){
        FramePanel orangePanel = this.addPanel(Color.ORANGE, 0, 0, 150, 700);
        FramePanel bluePanel = this.addPanel(Color.BLUE, 150, 100, 600, 250);
        FramePanel greenPanel = this.addPanel(Color.GREEN, 750, 0, 150, 700);
        //greenPanel.addLabel("Portfolio", 0, 0, "portfolio.png");
        //PanelButton button = bluePanel.addButton(200, 100, 100, 50);
        buttonDeposit = new PanelButton(400, 150 , 150, 50);
        buttonDeposit.setText("Deposit");
        buttonDeposit.setFont(new Font("Arial", Font.PLAIN, 20));
        //buttonDeposit.setFocusable(false);
        //buttonDeposit.addActionListener(this);
        bluePanel.add(buttonDeposit);
        depositField = new JTextField();
        depositField.setPreferredSize(new Dimension(80,30));
        //depositField.setBounds(450, 215, 100, 50);5
        bluePanel.add(depositField);

        buttonWithdraw = new PanelButton(400, 150 , 150, 50);
        buttonWithdraw.setText("Withdraw");
        buttonWithdraw.setFont(new Font("Arial", Font.PLAIN, 20));
        //buttonDeposit.setFocusable(false);
        //buttonDeposit.addActionListener(this);
        bluePanel.add(buttonWithdraw);
        withdrawField = new JTextField();
        withdrawField.setPreferredSize(new Dimension(80,30));
        //depositField.setBounds(450, 215, 100, 50);
        bluePanel.add(withdrawField);
    }

    public void addAllMenus(){
        JMenu refresh = new JMenu("Refresh");
        menuBar.add(refresh);

        this.setJMenuBar(menuBar);
    }

    public void addButtonDepositActionListener(ActionListener listener) {
        buttonDeposit.addActionListener(listener);
    }

    public void addButtonWithdrawActionListener(ActionListener listener) {
        buttonWithdraw.addActionListener(listener);
    }

    //@Override
   // public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == buttonDeposit){
        //  System.out.println("I was pressed");
        //}
   // }

}
