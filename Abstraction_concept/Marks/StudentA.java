public class StudentA extends Mark {
    int a, b, c; 
    
    StudentA(int a, int b, int c){
        this.a = a; 
        this.b = b; 
        this.c = c; 
    }

    public double getPercentage(){
        double result = ((a + b + c)*100)/300;  
        return result; 
    }
}
