package Future_Githubb.ValidUsernameRegularExpression;
import java.util.*; 


public class solution {
    //getting scanner object
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        //number of usernames to be entered
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}
