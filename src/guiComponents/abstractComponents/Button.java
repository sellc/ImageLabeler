package guiComponents.abstractComponents;

import javax.swing.JButton;

public abstract class Button {
	
	protected JButton button;
	
	public Button(String title, int x, int y, int width, int height) {
		init(title);
		setButton(x, y, width, height);
	}
	
	protected void init(String title) {
		button = new JButton(title);
	}
	
	protected void setButton(int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
	}
	
	public JButton getButton() {
		return button;
	}
	
	public int getX() {
		return button.getX();
	}

	public int getY() {
		return button.getY();
	}

	public int getWidth() {
		return button.getWidth();
	}

	public int getHeight() {
		return button.getHeight();
	}

}
