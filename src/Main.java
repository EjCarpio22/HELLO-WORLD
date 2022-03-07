import java.util.Scanner;

public  class Main {
        public static void main(String[] args) {
                Scanner lion = new Scanner(System.in);
                String test;
                System.out.println("Hi what is your name?");
                test = lion.nextLine();
                System.out.println("Nice to meet you " + test + "!");

                int paint1 = 100;
                int paint2 = 200;
                int paint3 = 400;

                Scanner length = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Input Length(ft): ");
                int Lvalue = length.nextInt();  // Read user input

                Scanner width = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Input Width(ft): ");
                int Wvalue = width.nextInt();  // Read user input

                System.out.println("Wall Area is: " + (Lvalue * Wvalue) + " sq.ft");
                System.out.println();

                Scanner walls = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Input no. of walls: ");
                double Wall = walls.nextDouble();  // Read user input

                Scanner paint = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Input Paint Size(ml): ");
                double Pvalue = paint.nextDouble();  // Read user input

                System.out.println();
                if (Pvalue == 500) {
                        System.out.println("Maximum coverage per can is: " + paint1 + " sq.ft");
                        System.out.println("The number of paint cans needed is: " + Math.round(Wall * (Lvalue * Wvalue) / paint1));
                } else if (Pvalue == 750) {
                        System.out.println("Maximum coverage per can is: " + paint2 + " sq.ft");
                        System.out.println("Number of cans needed is: " + Math.round(Wall * (Lvalue * Wvalue) / paint2));
                } else if (Pvalue == 1000) {
                        System.out.println("Maximum coverage per can is: " + paint3 + " sq.ft");
                        System.out.println("The number of paint cans needed is: " + Math.round(Wall * (Lvalue * Wvalue) / paint3));
                } else {
                        System.out.println("Please enter 500, 750 or 1000 only");
                }

        }
}