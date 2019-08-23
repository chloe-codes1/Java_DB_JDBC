package day14_interface;

public class Rectangular extends shape implements Drawable, Movable{
	//+ 나중에 shape이 DrawAndMove를 implements함으로써, Rectangular이 Drawable과 Movable을 implements 할 필요 없게 됨!
	
	Point p;
	private int width;
	private int height;
	// -> width 와 height으로 중심점만 알면 좌표 4개 구할 수 있어서 Point 1개만 선언함

	public Rectangular() {
		super();
	}

	public Rectangular(Point point, int width, int height) {
		super();
		this.p = point;
		this.width = width;
		this.height = height;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}
	

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangular [p=" + p + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangular other = (Rectangular) obj;
		if (height != other.height)
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public void move(int m) {
		
		p.setX(p.getX() + m);
		p.setY(p.getY() + m);
	}

	public void draw() {
		System.out.println("사각형 그리기 ~~~");
	}

	@Override
	double area() {
		return width*height;
	}
}

