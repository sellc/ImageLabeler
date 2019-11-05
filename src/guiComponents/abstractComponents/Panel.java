package guiComponents.abstractComponents;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class Panel {
	
	protected JPanel panel;
	
	public Panel() {
		panel = new JPanel();
		setPanel();
		init();
		addComponents();
	}
	
	public abstract void init();
	
	public abstract void addComponents();
		
	public void setPanel() {
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		panel.setVisible(true);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public int getX() {
		return panel.getX();
	}
	
	public int getY() {
		return panel.getY();
	}
	
	public int getWidth() {
		return panel.getWidth();
	}
	
	public int getHeight() {
		return panel.getHeight();
	}

}
