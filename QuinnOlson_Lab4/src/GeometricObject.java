
public abstract class GeometricObject implements Comparable, Cloneable{
	protected double side;
	protected double area;
	
	public int compareTo(Object a) {
		GeometricObject o = (GeometricObject) a;
		if(this.side < o.side) return 1;
		else if(this.side > o.side) return -1;
		return 0;
		
	}
	
	public Object clone() {
		return this;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "\nSide Length: " + this.side
				+ "\nArea: " + this.area;
	}
}
