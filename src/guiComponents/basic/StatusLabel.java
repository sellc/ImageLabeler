package guiComponents.basic;

import guiComponents.abstractComponents.Label;

public class StatusLabel extends Label {
	
	public StatusLabel(int x, int y, int width, int height) {
		super("", x, y, width, height);
	}

	public void setStatus(int state) {
		switch(state) {
		case -1:
			label.setText("Error");
			label.setSize(100, 20);
			break;
		case 0:
			label.setText("Loading Image");
			label.setSize(130, 20);
			break;
		case 1:
			label.setText("Complete");
			label.setSize(100, 20);
			break;
		case 2:
			label.setText("File doesn't exist at this path");
			label.setSize(200, 20);
			break;
		default:
			label.setText("Undefined Status");
			label.setSize(100, 20);
		}
	}
	
}
