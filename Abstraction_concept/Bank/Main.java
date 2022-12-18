class Main {
    public static void main(String[] args)throws Exception{
        bankA user = new bankA(100); 
        bankB user1 = new bankB(150); 
        bankC user2 = new bankC(200); 

        System.out.println(user.getbalance());
        System.out.println(user1.getbalance());
        System.out.println(user2.getbalance());
    }
}
