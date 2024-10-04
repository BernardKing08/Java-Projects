package polymorphism.exercise;

public class Main {
	public static void main(String[]args) {
		Car car = new Car("2022 Blue ferrari 2296 gts"); 
		runRace(car);
		
		//creating a gas Powered car
		Car ferrari = new GasPoweredCar("2022 Blue ferrari 2296 gts", 15.4, 6);
		runRace(ferrari);

		//Creating an electric car
		Car tesla = new ElectricCar("2022 Blue ferrari 296 GTS", 15.4, 75);
		runRace(tesla);

		//creating a hybrid car
		Car ferrariHybrid = new HybridCar("2022 Black ferrari SF909 Stradale", 16, 8, 8);
		runRace(ferrariHybrid);
	}
	
	//creating a polymorphic object
	public static void runRace(Car car) {
		car.startEnging();
		car.drive();
	}
}
