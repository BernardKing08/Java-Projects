package polymorphism.exercise;

public class Car {
	private String description;
	
	public Car(String description) {
		super();
		this.description = description;
	}

	public void startEnging() {
		System.out.println("Car -> starting engine"); 
	}
	
	protected void runEngine() {
		System.out.println("Engine running");
	}
	
	public void drive() {
		System.out.println("Car - Driving " + getClass().getSimpleName());
		runEngine();
	}
	
	
}
