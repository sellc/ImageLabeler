package basic;

public class Square {

	private String label;
	private int x1, y1, x2, y2;

	public Square(String label, Coordinate one, Coordinate two) {
		this.label = label;
		setAllPoints(one, two);
	}
	
	public void setAllPoints(Coordinate one, Coordinate two) {
		if (one.getX() < two.getX()) {
			if (one.getY() < two.getY()) {
				x1 = one.getX();
				y1 = one.getY();
				x2 = two.getX();
				y2 = two.getY();
			} else {
				x1 = one.getX();
				y1 = two.getY();
				x2 = two.getX();
				y2 = one.getY();
			}
		} else {
			if (one.getY() < two.getY()) {
				x1 = two.getX();
				y1 = one.getY();
				x2 = one.getX();
				y2 = two.getY();
			} else {
				x1 = two.getX();
				y1 = two.getY();
				x2 = one.getX();
				y2 = one.getY();
			}
		}
	}
	
	public String getLabel() {
		return label;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}
	
	public int getWidth() {
		return x2-x1;
	}
	
	public int getHeight() {
		return y2-y1;
	}
		
	public String toJSON(double xScale, double yScale) {
		return "{\"label\":" + label + "," + "\"x1\":" + (int)(x1*xScale) + "," + "\"y1\":" + (int)(y1*xScale) + "," + "\"x2\":" + (int)(x2*xScale) + "," + "\"y2\":" + (int)(y2*xScale) + "}";
	}

	public String toString() {
		return "{label:" + label + "," + "x1:" + x1 + "," + "y1:" + y1 + "," + "x2:" + x2 + "," + "y2:" + y2 + "}";
	}

}
