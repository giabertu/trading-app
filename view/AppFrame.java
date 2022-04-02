package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

public class AppFrame extends JFrame implements Frame {
    
    public AppFrame() {

        this.setSize(700,500); //sets initial x and y dimension

        this.setTitle("Stock Trading App"); //gives a title to the frame (shown on top of it)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes sure that the app is killed
        //when you press on the close button, instead of hiding it.
        this.setIconImage(new ImageIcon("appIcon.png").getImage());
        this.getContentPane().setBackground(Color.lightGray); //change background color.
    
        //this.setResizable(false); //this prevents the frame from being resized
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

    public void addAllPanels(){
        FramePanel orangePanel = this.addPanel(Color.ORANGE, 0, 0, 250, 250);
        FramePanel bluePanel = this.addPanel(Color.BLUE, 250, 0, 250, 250);
        FramePanel greenPanel = this.addPanel(Color.GREEN, 0, 250, 500, 250);
        greenPanel.addLabel("Portfolio", 0, 0, "portfolio.png");
    }
}
