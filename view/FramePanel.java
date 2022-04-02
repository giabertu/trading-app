package view;

import java.awt.Color;
import javax.swing.JPanel;
/**
 * What is a Panel? It is just a section of the frame, and like one, you can
 * add components to it.
 * 
 * It implements a Frame interface as, just like a frame, a Panel allows to add labels to it.
 */
public class FramePanel extends JPanel implements Frame{
    
    public FramePanel(Color color, int x, int y, int width, int height){
        this.setBackground(color);
        this.setBounds(x, y, width, height);
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

    public PanelButton addButton(int x, int y, int width, int height){
        PanelButton button = new PanelButton(x, y, width, height);
        this.add(button);
        return button;
    }

    //public void addAllButtons(){
    //  PanelButton button = addButton(200, 100, 100 , 50);
    //} 
    

}
