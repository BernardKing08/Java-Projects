package challange1.TeenChecker;

public class TeenNumberChecker {
    // write code here
    public static boolean hasTeen(int a, int b,int c){
        if(((a <= 19) && (a >= 13)) || ((b <= 19) && (b >= 13) || ((c <= 19) && (c >= 13)))){
            return true;
        }
        else{
            return false;
        }
    }


    public static boolean isTeen(int a){
        if((a <= 19) && (a >= 13))
            return true;
        else
            return false;
    }
    
}