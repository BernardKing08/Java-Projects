package encapsulation.Printer;


public class Printer {
    // write code here
    private int tonerLevel;
    private int pagesPrinted; 
    private boolean duplex; 
    
    public Printer(int tonerLevel, boolean duplex){
        this.tonerLevel = tonerLevel > -1? (tonerLevel <= 100? tonerLevel : -1) : -1 ; 
		this.duplex = duplex; 
		pagesPrinted = 0;
    }

	public int addToner(int tonerAmount){
		if(tonerAmount < 100 && tonerAmount > 0){
			if((tonerAmount + tonerLevel) > 100){
				return -1;
			}
			else{
				tonerLevel += tonerAmount;
				return tonerLevel;
			}
		}
		return tonerAmount;
		
		
	}

	public int printPages(int pages){
		int pagesToPrint = pages; 

		if(duplex){
		    if(pagesToPrint % 2 != 0){
		        pagesToPrint += 1;
		    }
			pagesToPrint /= 2;
			pagesPrinted += pagesToPrint;
		}


		return pagesToPrint; 
	}

	public int getPagesPrinted() {
		return pagesPrinted;
	}
}