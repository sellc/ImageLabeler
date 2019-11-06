package guiComponents.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DrawImage {
	
	/**
	 * Draws the specified image onto the DrawingPanel. A valid file path must be
	 * provided first.
	 */
	public static void drawImage(Graphics g, BufferedImage image, JPanel panel) {
		if (image != null) {
			if(image.getWidth() < panel.getWidth()) {
				if(image.getHeight() < panel.getHeight()) {
					g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
				} else {
					g.drawImage(image, 0, 0, image.getWidth(), panel.getHeight(), null);
				}
			} else {
				if(image.getHeight() < panel.getHeight()) {
					g.drawImage(image, 0, 0, panel.getWidth(), image.getHeight(), null);
				} else {
					g.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), null);
				}
			}
		}
	}


}
