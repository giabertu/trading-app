package view;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class FrameLabel extends JLabel{

    //recall that position is taken from JLabel.CENTER;
    //CENTER: 0, TOP: 1, LEFT: 2, BOTTOM: 3, RIGHT 4.
    public FrameLabel(String title, int vertPos, int horPos){

        this.setText(title);
        this.setForeground(Color.RED); //changes color of the label
        this.setFont(new Font("Arial", Font.BOLD, 20)); //set text font and size
        this.setVerticalAlignment(vertPos);
        this.setHorizontalAlignment(horPos);
    }
    public FrameLabel(String title, int vertPos, int horPos, String icon){
        this(title, vertPos, horPos);
        this.setIcon(new ImageIcon(icon));
        this.setHorizontalTextPosition(JLabel.CENTER); //left, center, right of image icon
        this.setVerticalTextPosition(JLabel.TOP);
        this.setIconTextGap(10); //set gap of text and image

    }
}