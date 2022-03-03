public class Main {
    public static void main(String[] agrs){
      String thanks = "Thank you,";
      String name = "miguel";
      String order = "Your order is number #";
      int previousOrder = 715;

        System.out.println( thanks + name.toUpperCase()+ "!");
        System.out.println( order + ++previousOrder);



        int L= 40;
        int W= 60;
        int wallArea = L*W;
        int paint_sqft = 160;

        System.out.println("Amount of Paint needed is: " + wallArea / paint_sqft);

    }
}
