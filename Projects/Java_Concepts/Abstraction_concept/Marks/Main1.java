class Main1 {
    public static void main(String[] args){
        StudentA user = new StudentA(77, 70, 89); 
        StudentB user1 = new StudentB(99, 87, 77, 60); 

        System.out.println(user.getPercentage()); 
        System.out.println(user1.getPercentage()); 
    }
    
}
