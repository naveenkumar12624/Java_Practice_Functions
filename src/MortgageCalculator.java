import java.util.Scanner;

public class MortgageCalculator {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        double loanAmount = getValidDoubleInput(scanner, "Enter the loan Amount : ");
        double annualInterestRate = getValidDoubleInput(scanner, "Enter the Annual Interest Rate :");
        int loanTermInYears = getValidInput(scanner, "Enter the loan term (in years) :");

        double monthlyPayment = calculateMonthlyPayment(loanAmount,annualInterestRate,loanTermInYears);
        double totalPayment = monthlyPayment * loanTermInYears*12;
        double totalInterest = totalPayment-loanAmount;

        System.out.printf("Monthly Payment : %.2f%n" ,monthlyPayment);
        System.out.printf("Total Payment : %.2f%n", totalPayment);
        System.out.printf("Total Interest Paid : %.2f%n" , totalInterest);
    }

    private static double getValidDoubleInput(Scanner scanner,  String prompt){
        double value;
        while (true){
            System.out.print(prompt);
            if (scanner.hasNextDouble()){
                value = scanner.nextDouble();

                if (value>0){
                    break;
                }else{
                    System.out.println("please enter a positive number.");
                }
            }else {
                System.out.println("Enter a Valid Input Number");
                scanner.next();
            }
        }return value;
    }

    private static int getValidInput(Scanner scanner, String prompt){
        int value;
        while(true){
            System.out.print("Enter the Loan Term(In Year) :");
            if(scanner.hasNextInt()){
                value = scanner.nextInt();
                if (value>0){
                    break;
                }
                else{
                    System.out.println("Enter a positive Value");
                }
            }else{
                System.out.println("Invalid Input. Enter a valid Integer");
                scanner.next();
            }
        }return  value;
    }

    private static double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int loanTermInYears ){
        double monthlyInterestRate = annualInterestRate/100/12;
        int numberOfPayments = loanTermInYears*12;
        return loanAmount* (monthlyInterestRate *  Math.pow(1+monthlyInterestRate, numberOfPayments))
                / (Math.pow(1+ monthlyInterestRate, numberOfPayments)-1);
    }
}
