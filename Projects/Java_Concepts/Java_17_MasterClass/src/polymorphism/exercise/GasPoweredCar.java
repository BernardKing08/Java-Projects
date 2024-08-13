package polymorphism.exercise;

public class GasPoweredCar extends Car{

	private double avgKmPerLitre;
	private int cylinders = 6;
	
	public GasPoweredCar(String description) {
		super(description);
		
	}

	public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
		super(description);
		this.avgKmPerLitre = avgKmPerLitre;
		this.cylinders = cylinders;
	}

	@Override
	public void startEnging() {
		// TODO Auto-generated method stub
		super.startEnging();
		System.out.printf("All %d cylinders fired up", cylinders);
	}

	@Override
	protected void runEngine() {
		super.runEngine();
		System.out.printf("Gas uses the average: 15.40", avgKmPerLitre);
	}
	

}
