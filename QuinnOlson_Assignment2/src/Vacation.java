//Quinn Olson

public abstract class Vacation {
	
	protected int budget;
	protected String destination;
	
	public abstract int Budget();
	
	@Override
	public String toString() {
		return this.getClass().getName() + " to " + destination + "\nBudget:\t$" + budget;
	}
	
	public int getBudget() {
		return budget;
	}
	
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
