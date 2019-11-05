package guiComponents.basic;

import java.awt.Color;

import guiComponents.abstractComponents.Label;

public class TagLabel extends Label {

	public TagLabel(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height);
		label.setOpaque(true);
		label.setBackground(Color.yellow);
	}

}
