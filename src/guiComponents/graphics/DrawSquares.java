package guiComponents.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import basic.Coordinate;
import basic.Square;

public class DrawSquares {
	
	private static Square tempSquare = new Square("temp", new Coordinate(0, 0), new Coordinate(0,0));

	public static void drawSquares(LinkedList<Square> squares, Graphics g) {
		int index = 0;
		while (index < squares.size()) {
			g.setColor(Color.ORANGE);
			g.drawRect(squares.get(index).getX1(), squares.get(index).getY1(), squares.get(index).getWidth(), squares.get(index).getHeight());
			index++;
		}
	}

	public static void drawSquare(Coordinate one, Coordinate two, Graphics g) {
		tempSquare.setAllPoints(one, two);
		g.setColor(Color.ORANGE);
		g.drawRect(tempSquare.getX1(), tempSquare.getY1(), tempSquare.getWidth(), tempSquare.getHeight());
	}

}
