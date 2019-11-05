package guiComponents.complex;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window {

	private JFrame frame;
	private LoadPanel loadImagePanel;

	public Window() {
		frame = new JFrame("Image Labeler");
		setFrame();
		init();
		addComponents();
		setComponents();
	}

	public void init() {
		loadImagePanel = new LoadPanel();
	}

	public void addComponents() {
		frame.add(loadImagePanel.getPanel());
	}

	public void setComponents() {
		loadImagePanel.getPanel().setBounds(0, 0, frame.getWidth(), frame.getHeight());
	}

	public void setFrame() {
		frame.setBackground(Color.black);
		frame.setBounds(100, 100, Toolkit.getDefaultToolkit().getScreenSize().width - 200,
				Toolkit.getDefaultToolkit().getScreenSize().height - 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
