package view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PandaProdPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Color panelColor = PandaProdColor.BUTTON;
    private BufferedImage image;

    public PandaProdPanel() {
		super();
		initComponent();
    }
    
    public PandaProdPanel(File imageFile){
    	try {
			image = ImageIO.read(imageFile);
			panelColor = PandaProdColor.BACKGROUND_FRAME;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public PandaProdPanel(File imageFile, Color color){
    	try {
			image = ImageIO.read(imageFile);
			panelColor = color;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void initComponent() {
    	setOpaque(false);
    }
    
    public PandaProdPanel(Color color){
    	super();
    	panelColor = color;
		initComponent();
    }

    @Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(panelColor);
		g2d.fillRect(0, 0, w, h);
		setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(), 45));
		setSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 45));
		
		drawImage(g2d);
		
    }
    
    private void drawImage(Graphics g2d){
    	if(image != null){
			g2d.drawImage(image, 0, 0, this);
			setSize(new Dimension(image.getWidth(), image.getHeight()));
                        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		}
    }
}
