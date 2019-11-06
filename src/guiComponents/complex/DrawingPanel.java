package guiComponents.complex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import basic.Coordinate;
import basic.Square;
import guiComponents.basic.TagLabel;
import guiComponents.graphics.DrawImage;
import guiComponents.graphics.DrawSquares;
import standalone.LoadImage;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private LinkedList<Square> squares;
	private Coordinate tempStart, tempCurrent;
	private LinkedList<TagLabel> tagLabels;
	private String imgFilePath;
	private BufferedImage image;

	private double xScale, yScale;

	public DrawingPanel() {
		squares = new LinkedList<Square>();
		tagLabels = new LinkedList<TagLabel>();
		drawSquare();
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setVisible(false);
		this.setVisible(true);
	}

	/**
	 * Sets the file path and attempts to load the image. If the image is loaded,
	 * the x and y scales are set then the panel is reset.
	 * 
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		imgFilePath = filePath;
		image = LoadImage.loadImage(imgFilePath);
		if (image != null) {
			setScales();
			resetPanel();
		}
	}

	private void drawSquare() {
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				tempStart = new Coordinate(arg0.getPoint().x, arg0.getPoint().y);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				tempCurrent = new Coordinate(arg0.getPoint().x, arg0.getPoint().y);
				// Pop-up with label option
				String s = (String) JOptionPane.showInputDialog("Label this object: ");
				System.out.println(s);
				if (s != null) {
					squares.add(new Square(s, tempStart, tempCurrent));
					tagLabels.add(new TagLabel(s, squares.get(squares.size() - 1).getX1(),
							squares.get(squares.size() - 1).getY1(), 100, 20));
					addTagLabel();
				}
				tempStart = null;
				tempCurrent = null;
				resetPanel();
			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				tempCurrent = new Coordinate(e.getPoint().x, e.getPoint().y);
				resetPanel();
				grabFocus();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				grabFocus();
			}

		});
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				switch (arg0.getKeyCode()) {
				case KeyEvent.VK_Z:
					if (squares.size() > 0) {
						squares.remove(squares.size() - 1);
						removeTagLabel();
					}
					resetPanel();
					grabFocus();
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

	private void addTagLabel() {
		this.add(tagLabels.get(tagLabels.size() - 1).getLabel());
	}

	private void removeTagLabel() {
		this.remove(tagLabels.get(tagLabels.size() - 1).getLabel());
		tagLabels.remove(tagLabels.size() - 1);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		DrawImage.drawImage(g, image, this);
		DrawSquares.drawSquares(squares, g);
		if (tempStart != null) {
			DrawSquares.drawSquare(tempStart, tempCurrent, g);
		}
	}


	/**
	 * Set the scales of the labeling boxes. If an image must be scaled to fit
	 * inside the DrawingPanel then the box points must also be scaled to match the
	 * full size image.
	 * 
	 * @param None
	 */
	private void setScales() {
		xScale = (double) image.getWidth() / this.getWidth();
		yScale = (double) image.getHeight() / this.getHeight();
	}

	/**
	 * Resets the DrawingPanel.
	 */
	public void resetPanel() {
		this.setVisible(false);
		this.setVisible(true);
	}

	public LinkedList<Square> getSquares() {
		return squares;
	}

	/**
	 * Returns the x scale of the image.
	 * 
	 * @return x scale
	 */
	public double getXScale() {
		return xScale;
	}

	/**
	 * Returns the y scale of the image.
	 * 
	 * @return y scale
	 */
	public double getYScale() {
		return yScale;
	}

}
