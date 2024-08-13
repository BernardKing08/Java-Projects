package polymorphism.challange;

public class Car {
	private boolean engine; 
	private int cylinders;
	private String name; 
	private int wheels;
	
	public Car(int cylinders, String name) {
		super();
		this.cylinders = cylinders;
		this.name = name;
	}
	
	public void startEngine() {
		System.out.println(getClass().getSimpleName() + " -> startEngine()");
	}
	
	public void accelerate() {
		System.out.println(getClass().getSimpleName() + " -> accelerate()");
	}
	
	public void brake() {
		System.out.println(getClass().getSimpleName() + " -> brake()");
	}

	public boolean isEngine() {
		return engine;
	}

	public int getCylinders() {
		return cylinders;
	}

	public String getName() {
		return name;
	}

	public int getWheels() {
		return wheels;
	}
	
	
}
