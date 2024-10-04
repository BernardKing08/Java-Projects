package polymorphism.exercise;

public class HybridCar extends Car{

	private double avgKmPerCharge;
	private int batterySize = 6; 
    private int cylinders;
	
	public HybridCar(String description) {
		super(description);
		
	}

	public HybridCar(String description, double avgKmPerCharge, int batterySize, int cylinders) {
		super(description);
        this.cylinders = cylinders;
		this.avgKmPerCharge = avgKmPerCharge;
		this.batterySize = batterySize;
	}

	@Override
	public void startEnging() {
		super.startEnging();
        System.out.printf("Hybrid -> %d cylinders fired up", cylinders);
	 	System.out.printf("All %d batterySize fired up", batterySize);
	}

	@Override
	protected void runEngine() {
		super.runEngine();
		System.out.printf("Charge uses the average: 15.40", avgKmPerCharge);
	}
	
}
