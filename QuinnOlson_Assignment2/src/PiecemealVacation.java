//Quinn Olson

public class PiecemealVacation extends Vacation {
	
	private String[] items;
	private int[] costs;
	
	public PiecemealVacation() {
		this(0, "", null, null);
	}
	
	public PiecemealVacation(int budget, String destination, String[] items, int[] costs) {
		this.budget = budget;
		this.destination = destination;
		this.items = items;
		this.costs = costs;
	}
	
	public int Budget() {
		int totalCost = 0;
		for(int i = 0; i < costs.length; i++) {
			totalCost += costs[i];
		}
		return budget - totalCost;
	}
	
	@Override
	public String toString() {
		String printItems = "\n" + items.length + " Trip Item" + (items.length > 1 ? "s\n" : "\n");
		for(int i = 0; i < items.length; i++) {
			printItems += items[i] + ":\t$" + costs[i] + "\n";
		}
		return super.toString() + printItems + "You are $" + Math.abs(Budget()) + (Budget() > 0 ? " under-" : " over-") + "budget";
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public int[] getCosts() {
		return costs;
	}

	public void setCosts(int[] costs) {
		this.costs = costs;
	}
	
}
