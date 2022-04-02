package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;


public class AppFrame extends JFrame implements ActionListener, Frame {
    
    PanelButton buttonDeposit;

    public AppFrame() {

        this.setSize(900,700); //sets initial x and y dimension
        this.setTitle("Stock Trading App"); //gives a title to the frame (shown on top of it)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes sure that the app is killed
        //when you press on the close button, instead of hiding it.
        this.setIconImage(new ImageIcon("appIcon.png").getImage());
        this.getContentPane().setBackground(Color.lightGray); //change background color.
    
        this.setResizable(false); //this prevents the frame from being resized
        this.setVisible(true); //make frame visible

        addAllPanels();
        this.setLayout(null);
        //this.pack(); //sets the size of frame to accomodate all components. Make sure to add
        //All components before using pack. 
        
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
        buttonDeposit = new PanelButton(450, 50 , 75, 35);
        buttonDeposit.setText("Deposit");
        buttonDeposit.setFont(new Font("Arial", Font.BOLD, 10));
        buttonDeposit.setFocusable(false);
        buttonDeposit.addActionListener(this);
        bluePanel.add(buttonDeposit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDeposit){
            System.out.println("I was pressed");
        }
    }

}
