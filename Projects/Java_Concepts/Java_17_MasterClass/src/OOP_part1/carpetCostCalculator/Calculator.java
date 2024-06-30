package OOP_part1.carpetCostCalculator;
public class Calculator {

	private Floor floor; 
	private Carpet carpet;
	

	public Calculator(Floor floor, Carpet carpet) {
		super();
		this.floor = floor;
		this.carpet = carpet;
	}
	
	public double getTotalCost() {
        return floor.getArea() * carpet.getCost();
    }

}