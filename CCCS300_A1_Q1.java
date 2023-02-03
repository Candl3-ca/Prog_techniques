/*
* Name: 
* StudentID: 
*
/

public class CCCS300_A1_Q1 {
    public static void main(String[] args) {

        // defining the variables

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        final int RUNNING6MPH_METS = 10;
        final int BASKETBALL_METS = 8;
        final int SLEEPING_METS = 1;

        /1st input argument is an integer value that represents the weight in pounds of a person who is running 6 MPH for 30 minutes every day.
        2nd input argument is an integer value that represents the weight in pounds of a person who is playing basketball for 60 minutes every day.
        3rd input argument is an integer value that represents the weight in pounds of a person who is sleeping for 6 hours every day./


        double A = (a/2.2) RUNNING6MPH_METS * 0.0175 * 30;
        double B = (b/2.2)* BASKETBALL_METS * 0.0175 * 60;
        double C = (c/2.2)* SLEEPING_METS * 0.0175 * 360;


        // printing the results to the console

        System.out.printf("Welcome to the calorie calculator!"
                      + "\nA " + a + "LB person burned an estimated %.2f calories by Running."
                      + "\nA " + b + "LB person burned an estimated %.2f calories by playing Basketball."
                      + "\nA " + c + "LB person burned an estimated %.2f calories by Sleeping.", A, B, C);
    }
}
