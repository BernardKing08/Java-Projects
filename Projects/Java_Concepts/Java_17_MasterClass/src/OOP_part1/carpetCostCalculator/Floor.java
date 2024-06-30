package OOP_part1.carpetCostCalculator;
public class Floor {
	
	private double width; 
	private double length;
	
	public Floor(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}
	
	
	public double getArea() {
        return this.width * this.length;
    }
	

}
