
public class Driver {
	public static void main(String[] args) {
		GeometricObject geo = new Octagon();
		Octagon oct = new Octagon();
		Octagon oct2 = (Octagon) oct.clone();
		
		int compared = oct.compareTo(oct2);
		
		if(compared == 0) System.out.println("The two Octagons are the same");
		else if(compared == -1) System.out.println("Octagon 2 is smaller.");
		else System.out.println("Octagon 2 is bigger");
		System.out.println(oct + "\n" + oct2);
	}
}
