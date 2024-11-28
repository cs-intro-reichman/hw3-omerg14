public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				x1--;
			}
		}
		return x1;
	}
	
	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	public static int times(int x1, int x2) {
		int sum = 0;
		if (x1 > 0 && x2 > 0) {
			for (int i = 0; i < x2; i++) {
				sum = plus(sum, x1);			
			}
		} else if (x1 < 0 && x2 < 0) {
			x1 = -x1;
			x2 = -x2;
			for (int i = 0; i < x2; i++) {
				sum = plus(sum, x1);			
			}	
		} else if (x1 > 0 && x2 < 0) {
			x2 = -x2;
			for (int i = 0; i < x2; i++) {
				sum = minus(sum, x1);

			}
		} else if (x1 < 0 && x2 > 0) {
			x1 = -x1;
			for (int i = 0; i < x2; i++) {
				sum = minus(sum, x1);			
			}
		}
		return sum;
	}

	public static int pow(int x, int n) {
		int result = 1;
		if (n == 0) {
			return 1; 
		} else if (x == 0 && n > 0) {
			return 0; 
		} else if (n < 0 && x < 0) {
			return 0; 
		} else if (n > 0 && x > 0) {
			for (int i = 0; i < n; i++) {
				result = times(result, x);
			}
		}
		return result;
	}
	
	public static int div(int x1, int x2) {
		if (x2 == 0) {
			throw new ArithmeticException("Division by zero");
		}
		int result = 0;
		int sign = 1;
		if (x1 < 0) {
			x1 = -x1;
			sign = -sign;
		}
		if (x2 < 0) {
			x2 = -x2;
			sign = -sign;
		}
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			result++;
		}
		return result * sign;
	}
		
	public static int mod(int x1, int x2) {
		if (x2 == 0) {
			throw new ArithmeticException("Division by zero");
		}
		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}
		if (x1 < 0) {
			x1 = plus(x1, x2);
		}
		return x1;
	}
	
	public static int sqrt(int x) {
		int result = 0;
		if (x < 0) {
			throw new IllegalArgumentException("Square root of negative number");
		} else if (x == 0 || x == 1) {
			return x;
		} else {
			for (int i = 1; times(i, i) <= x; i++) {
				result = i;
			}
		}
		return result;
	}
}