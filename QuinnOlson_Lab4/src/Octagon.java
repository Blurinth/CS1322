
public class Octagon extends GeometricObject {
	
	public Octagon() {
		this.side = 8;
		this.area = 2 * (1 + Math.sqrt(2)) * (Math.pow(this.side, 2));
	}
	
}
