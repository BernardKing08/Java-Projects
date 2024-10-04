package Composition;


public class Bedroom {
	@SuppressWarnings("unused")
	private String name; 

	@SuppressWarnings("unused")
	private Wall wall1, wall2, wall3, wall4;
	@SuppressWarnings("unused")
	private Ceiling ceiling;
	private Bed bed; 
	private Lamp lamp;
	
	public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed, Lamp lamp) {
		super();
		this.name = name;
		this.wall1 = wall1;
		this.wall2 = wall2;
		this.wall3 = wall3;
		this.wall4 = wall4;
		this.ceiling = ceiling;
		this.bed = bed;
		this.lamp = lamp;
	}
	
	public Lamp getLamp() {
		return lamp;
	}

	public void makeBed(){
	    System.out.print("Bedroom -> Making bed | ");
        bed.make();
	}
	
	
}
