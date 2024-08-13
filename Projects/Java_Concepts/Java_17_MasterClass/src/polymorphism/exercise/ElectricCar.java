

package polymorphism.exercise;

public class ElectricCar extends Car{

	private double avgKmPerCharge;
	private int batterySize = 6;
	
	public ElectricCar(String description) {
		super(description);
		
	}

	public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
		super(description);
		this.avgKmPerCharge = avgKmPerCharge;
		this.batterySize = batterySize;
	}

	@Override
	public void startEnging() {
		super.startEnging();
	 	System.out.printf("All %d batterySize fired up", batterySize);
	}

	@Override
	protected void runEngine() {
		super.runEngine();
		System.out.printf("Charge uses the average: 15.40", avgKmPerCharge);
	}
	
}
