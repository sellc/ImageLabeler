package guiComponents.abstractComponents;

import javax.swing.JTextField;

public abstract class Field {
	
	private JTextField field;
	
	public Field(int size, int x, int y, int width, int height) {
		init(size);
		setField(x, y, width, height);
	}
	
	public void init(int size) {
		field = new JTextField(size);		
	}
	
	public void setField(int x, int y, int width, int height) {
		field.setBounds(x, y, width, height);
	}
	
	public JTextField getField() {
		return field;
	}
	
	public String getText() {
		return field.getText();
	}
		
	public int getX() {
		return field.getX();
	}
	
	public int getY() {
		return field.getY();
	}
	
	public int getWidth() {
		return field.getWidth();
	}
	
	public int getHeight() {
		return field.getHeight();
	}

}
