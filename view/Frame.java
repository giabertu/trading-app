package view;


/**
 * 
 * Interface to emulate the essential behavior of a frame. 
 * Common both to frames and panels. 
 * 
 */
public interface Frame {
    
    public abstract FrameLabel addLabel(String title, int vertPos, int horPos);

    public abstract FrameLabel addLabel(String title, int vertPos, int horPosm, String icon);
}
