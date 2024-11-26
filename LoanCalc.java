public class LoanCalc {
	
	static double epsilon = 0.001; 
	static int iterationCounter;   

	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {	
		double balance = loan;
		for (int i = 0; i < n; i++) {
			balance = (balance - payment) * (1 + rate / 100);
		}
		return balance;
	}

   	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
    	double payment = loan / n;
    	iterationCounter = 0;
		while (endBalance(loan, rate, n, payment) > 0) {
			iterationCounter++;
			payment += epsilon;
		}
		return payment;
	}

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double low = 0;
		double high = loan;
		double payment = 0;
		iterationCounter = 0;
		while (high - low > epsilon) {
			iterationCounter++;
			payment = (low + high) / 2;
			double balance = endBalance(loan, rate, n, payment);
			if (balance > 0) {
				low = payment; 
			} else {
				high = payment; 
			}
		}
		return payment;
	}
}
