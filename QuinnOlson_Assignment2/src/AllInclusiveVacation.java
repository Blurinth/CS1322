//Quinn Olson

public class AllInclusiveVacation extends Vacation {
	
	private String brand;
	private short rating;
	private int price;
	
	public AllInclusiveVacation() {
		this(0, "", "", (short) 0, 0);
	}
	
	public AllInclusiveVacation(int budget, String destination, String brand, short rating, int price) {
		this.budget = budget;
		this.destination = destination;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
	}
	
	public int Budget() {
		return budget - price;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nBrand:\t" + brand + "\nRating:\t" + rating + (rating > 1 ? "stars" : "star") + "\nPrice:\t$" + price + "\nYou are $"
				+ Math.abs(Budget()) + (Budget() > 0 ? " under-" : " over-") + "budget";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Short getRating() {
		return rating;
	}

	public void setRating(Short rating) {
		this.rating = rating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setting price to " + price);
		this.price = price;
	}
	
	
}
