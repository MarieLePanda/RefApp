package view.component;


import interfaces.IJFrame;
import java.util.HashMap;

import javax.swing.JFrame;

public abstract class PandaProdFrame extends JFrame implements IJFrame{
    
    private static final long serialVersionUID = 1L;
    
    protected HashMap<String, Object> hsJcomponent;

    public PandaProdFrame(){
        hsJcomponent = new HashMap<>();
        initBaseComponents();
    }

    private void initBaseComponents() {
        //setBackground(new Color(0, 175, 240));
        //getContentPane().setBackground(new Color(0, 175, 240));
        //setBackground(new Color(44, 62, 80));
        getContentPane().setBackground(PandaProdColor.BACKGROUND_FRAME);
    }
    
    public HashMap<String, Object> getJComponent() {
        return hsJcomponent;
    }

    @Override
    public void refresh() {
        validate();
        repaint();
        revalidate();
    }
    
    abstract public void putComponents();
    
    abstract public void configFrame();
}
