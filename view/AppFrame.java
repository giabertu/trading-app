package view;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import control.User;


public class AppFrame<User> extends JFrame implements Frame {
    
    public JButton buttonDeposit;
    public JButton buttonWithdraw;
    public JTextField depositField;
    public JTextField withdrawField;
    public JLabel accountInfo;
    public JMenuBar menuBar = new JMenuBar();

    public AppFrame() {

        this.setSize(900,700); //sets initial x and y dimension
        this.setTitle("Stock Trading App"); //gives a title to the frame (shown on top of it)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes sure that the app is killed
        //when you press on the close button, instead of hiding it.
        this.setIconImage(new ImageIcon("appIcon.png").getImage());
        this.getContentPane().setBackground(Color.lightGray); //change background color.
    
        //this.setResizable(false); //this prevents the frame from being resized

        this.setLayout(new BorderLayout(10,10));
        addAllPanels();
        addAllMenus();

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

        /************************ CREATING, ADDING PANELS***************/
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel centerPanel = new JPanel();

        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.GREEN);
        panel3.setBackground(Color.YELLOW);
        panel4.setBackground(Color.MAGENTA);
        centerPanel.setBackground(Color.BLUE);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        centerPanel.setPreferredSize(new Dimension(100,100));

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);

        /*********************** CENTER PANEL*************************/
        buttonDeposit = new JButton();
        buttonWithdraw = new JButton();

        buttonDeposit.setPreferredSize(new Dimension(100, 30));
        buttonWithdraw.setPreferredSize(new Dimension(100, 30));

        buttonDeposit.setText("Deposit");
        buttonWithdraw.setText("Withdraw");

        depositField = new JTextField();
        withdrawField = new JTextField();

        depositField.setPreferredSize(new Dimension(75, 20));
        withdrawField.setPreferredSize(new Dimension(75, 20));


        centerPanel.add(buttonDeposit);
        centerPanel.add(depositField);

        centerPanel.add(buttonWithdraw);
        centerPanel.add(withdrawField);

        /***********************TOP PANEL************************* */
        accountInfo = new JLabel();
        accountInfo.setText("Account Value: $0"  +
         "\nFree balance: $0");
        
        panel1.add(accountInfo);




        /**

        //FramePanel orangePanel = this.addPanel(Color.ORANGE, 0, 0, 150, 700);
        //FramePanel bluePanel = this.addPanel(Color.BLUE, 150, 0, 600, 250);
        //FramePanel greenPanel = this.addPanel(Color.GREEN, 750, 0, 150, 700);
        bluePanel.setLayout(null);
        //greenPanel.addLabel("Portfolio", 0, 0, "portfolio.png");
        //PanelButton button = bluePanel.addButton(200, 100, 100, 50);
        buttonDeposit = new PanelButton(0, 150 , 100, 40);
        buttonDeposit.setText("Deposit");
        buttonDeposit.setFont(new Font("Arial", Font.PLAIN, 15));
        //buttonDeposit.setFocusable(false);
        //buttonDeposit.addActionListener(this);
        bluePanel.add(buttonDeposit);
        depositField = new JTextField();
        //depositField.setPreferredSize(new Dimension(80,30));
        depositField.setBounds(125, 150, 80, 40);
        bluePanel.add(depositField);

        buttonWithdraw = new PanelButton(300, 150 , 100, 40);
        buttonWithdraw.setText("Withdraw");
        buttonWithdraw.setFont(new Font("Arial", Font.PLAIN, 15));
        //buttonDeposit.setFocusable(false);
        //buttonDeposit.addActionListener(this);
        bluePanel.add(buttonWithdraw);
        withdrawField = new JTextField();
        //withdrawField.setPreferredSize(new Dimension(80,30));
        depositField.setBounds(425, 150, 80, 40);
        bluePanel.add(withdrawField);
        */
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

    public void displayAccount(JLabel label, User user){
        label.setText("Account Value: " + ((control.User) user).getAccount().getTotBalance() +
         "\nFree balance: " + ((control.User) user).getAccount().getFreeBalance());
    }

    //@Override
   // public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == buttonDeposit){
        //  System.out.println("I was pressed");
        //}
   // }

}
