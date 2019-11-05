package guiComponents.complex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import guiComponents.abstractComponents.Panel;
import guiComponents.basic.FilePathField;
import guiComponents.basic.FilePathLabel;
import guiComponents.basic.LoadButton;
import guiComponents.basic.SaveBoxesButton;
import guiComponents.basic.StatusLabel;
//import guiComponents.basic.ToggleImageButton;
import standalone.ValidFilePath;
import standalone.WriteOutSquaresInJSON;

public class LoadPanel extends Panel {

	private final int infoBarHeight = 30;
	private final int buffer = 10;
	
	private FilePathLabel label;
	private FilePathField field;
	private LoadButton load;
	private StatusLabel status;
	private DrawingPanel drawPanel;
	private SaveBoxesButton saveBoxes;

	public LoadPanel() {
		super();
		setComponents();
	}

	public void init() {
		System.out.println(panel.getWidth());
		label = new FilePathLabel(panel.getX() + buffer, 5, 60, infoBarHeight-10);
		field = new FilePathField(label.getX() + label.getWidth() + buffer, label.getY(), 400, label.getHeight());
		load = new LoadButton(field.getX() + field.getWidth() + buffer, field.getY(), 100, field.getHeight());
		saveBoxes = new SaveBoxesButton("Save Boxes", load.getX() + load.getWidth() + buffer, load.getY(), 150, load.getHeight());		
		status = new StatusLabel(saveBoxes.getX() + saveBoxes.getWidth() + buffer, saveBoxes.getY(), 0, saveBoxes.getHeight());
		drawPanel = new DrawingPanel();
	}

	public void addComponents() {
		panel.add(label.getLabel());
		panel.add(field.getField());
		panel.add(load.getButton());
		panel.add(status.getLabel());
		panel.add(saveBoxes.getButton());
		panel.add(drawPanel);
	}

	public void setComponents() {
		setLoadImageButton();
		setFilePathField();
		setSaveBoxes();
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setLoadImageButton() {
		load.getButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				drawOnPanel();
			}

		});
	}

	public void setFilePathField() {
		field.getField().addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				switch(arg0.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					drawOnPanel();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			
		});
	}
	
	private void setSaveBoxes() {
		saveBoxes.getButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WriteOutSquaresInJSON.writeOut(field.getText(), drawPanel.getSquares(), drawPanel.getXScale(), drawPanel.getYScale());
			}
			
		});
	}


	public void drawOnPanel() {
		if (ValidFilePath.validFilePath(field.getText())) {
			status.setStatus(0);
			drawPanel.setBounds(0, infoBarHeight, panel.getWidth(), panel.getHeight() - infoBarHeight);
			drawPanel.setFilePath(field.getText());
			status.setStatus(1);
			drawPanel.resetPanel();
		} else {
			status.setStatus(2);
		}
	}

	public void resetPanel() {
		panel.setVisible(false);
		panel.setVisible(true);
	}

}
