public class StudentB extends Mark{
    int a, b, c, d; 
    
    StudentB(int a, int b, int c, int d){
        this.a = a; 
        this.b = b; 
        this.c = c; 
        this.d = d; 
    }

    public double getPercentage(){
        double result = ((a + b + c + d)*100)/400; 
        return result; 
    }
    
}
