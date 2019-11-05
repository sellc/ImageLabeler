package guiComponents.abstractComponents;

import javax.swing.JLabel;

public abstract class Label {

	protected JLabel label;

	public Label(String title, int x, int y, int width, int height) {
		init(title);
		setLabel(x, y, width, height);
	}

	public void init(String title) {
		label = new JLabel(title);
	}
	
	public void setLabel(int x, int y, int width, int height) {
		label.setBounds(x, y, width, height);
	}

	public JLabel getLabel() {
		return label;
	}

	public int getX() {
		return label.getX();
	}

	public int getY() {
		return label.getY();
	}

	public int getWidth() {
		return label.getWidth();
	}

	public int getHeight() {
		return label.getHeight();
	}

}
