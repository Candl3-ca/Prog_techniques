/*
 * Name: 
 * StudentID: 
 *
 */

import java.util.;
public class CCCS300_A1_Q2 {
    public static void main(String[] args) {

//        Defining the Scanner object
        Scanner s = new Scanner(System.in);

//        Defining the variables
        double P, S, Y, D, Y_D, NO_Y;

//        Getting the user input
        System.out.println("Welcome to the Depreciation calculator!");
        System.out.println("Enter values (Purchase price, Salvage value, and Years):");
        P = s.nextDouble();
        S = s.nextDouble();
        Y = s.nextDouble();

//        Calculating the results
        D = (P - S) / Y;
        Y_D = (D / P) * 100;
        NO_Y = (P - (P * 0.10)) / D;

//        Printing the results with one decimal place with Math.round
        System.out.println("Yearly Depreciation = " + Math.round(D) * 10 / 10.0);
        System.out.println("Yearly Depreciation = " + (Math.round(Y_D) * 10 / 10.0) + "%");
        System.out.println("Number of years for salvage value to be 10% of purchase price = " + Math.round(NO_Y) * 10 / 10.0);

    }
}
