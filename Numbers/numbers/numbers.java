package numbers;

import java.util.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class numbers {
	static String even_or_odd(int n) {
		if (n % 2 == 0) {
			return new String("even");
		}
		return new String("odd");
	}

	static int isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	static int sumOfPrime(int N) {
		int cnt;
		int a[] = new int[N];
		int sum = 0;
		int n = 0, c = 0, count = 0, k = 0;
		for (int i = 2; i <= n; i++) {
			cnt = 1;
			for (int j = 2; j <= n / 2; j++) {
				if (i % j == 0)
					cnt = 0;
			}
			if (cnt == 1) {
				a[k] = i;
				k++;
			}

		}
		for (int i = 0; i < k; i++) {
			sum = sum + a[i];
			c = isPrime(sum);
			if (c == 1)
				count++;
		}
		return count;
	}

	static void nthPrime(int n) {
		int i = 2;
		while (n != 0) {
			if (isPrime(i) == 1) {
				n--;
			}
			i++;
		}
		System.out.println(i - 1);
	}

	static void PrimeNumbers(int x, int y) {
		for (int i = x; i <= y; i++) {
			int count = 0;
			for (int j = 2; j < x; j++) {
				if (i % j == 0) {
					count += 1;
					break;
				}
			}
			if (count == 0) {
				if (isPrime(reverse(i)) == 1) {
					if (!(i == reverse(i))) {
						System.out.print(i + " ");
					}
				}
			}
		}
	}

	static void PrimeNumber(int x) {
		for (int i = 2; i <= x; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count += 1;
					break;
				}
			}
			if (count == 0) {
				System.out.print(i + " ");
			}
		}
	}

	static int PrimeNumbers1(int x, int y) {
		int sum = 0;
		for (int i = x; i <= y; i++) {
			int count = 0;
			for (int j = 2; j < x; j++) {
				if (i % j == 0) {
					count += 1;
					break;
				}
			}
			if (count == 0) {
				if (isPrime(reverse(i)) == 1) {
					sum += i;
				}
			}
		}
		return sum;
	}

	static void Prime_factor(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i) == 1) {
				int x = n;
				while (x % i == 0) {
					System.out.print(i + " ");
					x /= i;
				}
			}
		}
	}

	static int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	static BigInteger circularSeating(int num) {
		BigInteger res = BigInteger.ONE;
		for (int i = num; i > 0; i--) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}

	static String Harshad_number(int n) {
		// An integer number in base 10 which is divisible by the sum of its digits is
		// said to be a Harshad Number. An n-Harshad number is an integer number
		// divisible by the sum of its digit in base n.
		// Below are the first few Harshad Numbers represented in base 10: 1, 2, 3, 4,
		// 5, 6, 7, 8, 9, 10, 12, 18, 20………
		int sum = 0;
		int n1 = n;
		while (n > 0) {
			int rem = n % 10;
			sum += rem;
			n = n / 10;
		}
		if (n1 % sum == 0) {
			return new String("Harshad Number");
		}
		return new String("Not a Harshad Number");
	}

	static String Automorphic_number(int n) {
		// An automorphic number is a number whose square ends in the same digits as the
		// number itself. A number n is called automorphic if:
		// n2 (mod 10d) = n where d is the number of digits in n.
		// Examples: n = 5: then n^2 = 25
		// Last digit of 25 is 5, so 5 is automorphic.
		int square = n * n;
		while (n != 0) {
			if (n % 10 != square % 10) {
				return new String("Not automorphic");
			}
			n /= 10;
			square /= 10;
		}
		return new String("Automorphic");
	}

	static String Perfect_number(int n) {
		// A Number that can be represented as the sum of it's factors except the number
		// itself is known as the Perfect Number.
		// Example
		// Input : 6
		// Factors of 6 except 6 are 1, 2 and 3.
		// When we add the three we get 6 itself. Therefore, it's a Perfect Num
		int sum = 0;
		int n1 = n;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		if (n1 == sum) {
			return new String("Perfect Number");
		}
		return new String("Not a Perfect Number");
	}

	static String Strong_number(int n) {
		// Strong Numbers are the numbers whose sum of factorial of digits is equal to
		// the original number. Given a number, check if it is a Strong Number or not.
		// Examples:
		// Input : n = 145
		// Sum of digit factorials = 1! + 4! + 5!= 1 + 24 + 120=145
		int sum = 0;
		int n1 = n;
		while (n > 0) {
			int rem = n % 10;
			sum = sum + factorial(rem);
			n = n / 10;
		}
		if (n1 == sum) {
			return new String("Strong Number");
		}
		return new String("Not a Strong Number");
	}

	static String Abundant_number(int n) {
		// A number n is said to be an Abundant Number if the sum of all the proper
		// divisors of the number denoted by sum(n) is greater than the value of the
		// number n. And the difference between these two values is called abundance.
		// Mathematically, if the below condition holds the number is said to be an
		// Abundant number:
		// sum(n)> n
		// abundance = sum(n) - n
		// sum(n): aliquot sum - The sum of all proper divisors of n
		// Example:
		// Consider the number 12.
		// Factors of 12 = 1, 2, 3, 4, 6 Sum of factors = 1 + 2 + 3 + 4 + 6 = 16
		// As 16 > 12 so 12 is an Abundant number.
		int sum = 0;
		int n1 = n;
		while (n > 0) {
			int rem = n % 10;
			sum = sum + factorial(rem);
			n = n / 10;
		}
		if (n1 < sum) {
			return new String("Abundant Number");
		}
		return new String("Not a Abundant Number");
	}

	static boolean Palindrome(int n) {
		int sum = 0;
		int n1 = n;
		while (n > 0) {
			int rem = n % 10;
			sum = sum * 10 + rem;
			n = n / 10;
		}
		if (n1 == sum) {
			return true;
		}
		return false;
	}

	static boolean SpyNumber(int n) {
		// A number is said to be a spy number if sum of its digits is equal to the
		// product of its digits. Taking the number 1124 as an example:
		// Sum of digits of 1124:= 1 + 1 + 2 + 4= 8
		// Product of digits of 1124:= 1 x 1 x 2 x 4= 8
		// As the sum of digits and product of digits is equal for 1124, hence it is a
		// Spy Number.
		int sum = 0;
		int mul = 1;
		while (n > 0) {
			int rem = n % 10;
			sum += rem;
			mul *= rem;
			n /= 10;
		}
		if (sum == mul) {
			return true;
		}
		return false;
	}

	static int nextPalindrome(int n) {
		while (n < 100000) {
			if (Palindrome(n)) {
				break;
			}
			n++;
		}
		return n;
	}

	static int reverse(int n) {
		int sum = 0;
		while (n > 0) {
			int rem = n % 10;
			sum = sum * 10 + rem;
			n = n / 10;
		}
		return sum;
	}

	static int Palindrome1(int n) {
		if (Palindrome(n)) {
			return n;
		} else {
			int sum = n + reverse(n);
			return Palindrome1(sum);
		}
	}

	static void Palindrome_number(int n) {
		// A given number can be said palindromic in nature if the reverse of the given
		// number is the same as that of a given number. In this article, we will write
		// a Program to check if a number is a Palindrome Number in Java.
		// Example of Palindrome Number
		// Input : n = 46355364
		// Output: Reverse of n = 46355364
		// Palindrome : Yes
		for (int i = 1; i < n; i++) {
			int n1 = i;
			int sum = 0;
			while (n1 > 0) {
				int rem = n1 % 10;
				sum = sum * 10 + rem;
				n1 = n1 / 10;
			}
			if (i == sum) {
				System.out.print(i + " ");
			}
		}
	}

	static void Armstrong_number(int n) {
		for (int i = 1; i < n; i++) {
			int n1 = i;
			int sum = 0;
			while (n1 > 0) {
				int rem = n1 % 10;
				sum += Math.pow(rem, 3);
				n1 = n1 / 10;
			}
			if (i == sum) {
				System.out.print(i + " ");
			}
		}
	}

	static int Power(int base, int exp) {
		int res = 1;
		while (exp != 0) {
			res *= base;
			exp--;
		}
		return res;
	}

	static String Armstrong1(int n) {
		// A positive integer of n digits is called an Armstrong number of order n
		// (order is the number of digits) if
		// abcd… = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ….
		// Here a, b, c and d are digits of input number abcd…..
		// input:153
		// Output: Yes
		// Explanation: 153 is an Armstrong number, 1*1*1 + 5*5*5 + 3*3*3 = 153
		int n1 = n;
		int sum = 0;
		int digit = 0;
		while (n > 0) {
			n = n / 10;
			digit++;
		}
		n = n1;
		while (n > 0) {
			int rem = n % 10;
			sum += Math.pow(rem, digit);
			n = n / 10;
		}
		if (n1 == sum) {
			return new String("Armstrong");
		}
		return new String("Not Armstrong");
	}

	static int autobiographical(int n) {
		// An autobiographical number is a number such that the first digit of it counts
		// how many zeroes are there in it, the second digit counts how many ones are
		// there and so on.
		// For example, 1210 has 1 zero, 2 ones, 1 two and 0 threes.
		String s = Integer.toString(n);
		Set<Integer> s1 = new HashSet<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (Character.getNumericValue(s.charAt(j)) == i) {
					count++;
				}
			}
			if (!(Character.getNumericValue(s.charAt(i)) == count)) {
				return 0;
			}
			count = 0;
			s1.add(Character.getNumericValue(s.charAt(i)));
		}
		return s1.size();
	}

	static int binary_to_decimal(int binary) {
		int decimal = 0;
		int n = 0;
		while (binary > 0) {
			int temp = binary % 10;
			decimal += temp * Math.pow(2, n);
			binary = binary / 10;
			n++;
		}
		return decimal;
	}

	static int octal_to_decimal(int octol) {
		int decimal = 0;
		int n = 0;
		while (octol > 0) {
			int temp = octol % 10;
			decimal += temp * Math.pow(8, n);
			octol = octol / 10;
			n++;
		}
		return decimal;
	}

	static int hexa_to_decimal(String hexa) {
		String digit = "0123456789ABCDEF";
		hexa = hexa.toUpperCase();
		int val = 0;
		for (int i = 0; i < hexa.length(); i++) {
			char c = hexa.charAt(i);
			int d = digit.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	static String decimal_to_binary(int decimal) {
		/*
		 * String binary="";
		 * while(decimal>0) {
		 * int rem=decimal%2;
		 * binary=Integer.toString(rem)+binary;
		 * decimal/=2;
		 * }
		 * return binary;
		 */
		return Integer.toBinaryString(decimal);
	}

	static String decimal_to_octal(int decimal) {
		String octal = "";

		while (decimal > 0) {
			int rem = decimal % 8;
			octal = Integer.toString(rem) + octal;
			decimal /= 8;
		}
		return octal;
		// return Integer.toOctalString(decimal);
	}

	static String decimal_to_hexa(int decimal) {
		String hexa = "";
		String hexachar = "0123456789abcdef";
		while (decimal > 0) {
			int rem = decimal % 16;
			hexa = hexachar.charAt(rem) + hexa;
			decimal /= 16;
		}
		return hexa;
		// return Integer.toHexString(decimal);
	}

	static int SpecFibo(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return SpecFibo(n - 1) * SpecFibo(n - 1) + SpecFibo(n - 2) * SpecFibo(n - 2);
	}

	public static String convertString(String str) {
		StringBuilder str1 = new StringBuilder();
		for (char ch : str.toCharArray()) {
			switch (ch) {
				case '0':
					str1.append("zero ");
					break;
				case '1':
					str1.append("one ");
					break;
				case '2':
					str1.append("two ");
					break;
				case '3':
					str1.append("three ");
					break;
				case '4':
					str1.append("four ");
					break;
				case '5':
					str1.append("five ");
					break;
				case '6':
					str1.append("six ");
					break;
				case '7':
					str1.append("seven ");
					break;
				case '8':
					str1.append("eight ");
					break;
				case '9':
					str1.append("nine ");
					break;
			}
		}
		return str1.toString();
	}

	public static String func(int index, String s1, String s2) {
		String str = s1 + s2;
		String res = "";
		for (int i = index; i < str.length(); i++) {
			res += str.charAt(i);
		}
		for (int i = 0; i < index; i++) {
			res += str.charAt(i);
		}
		return res;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println(even_or_odd(23));
		 * System.out.println(autobiographical(2020));
		 * System.out.println(Palindrome(121));
		 * System.out.println(Armstrong(153));
		 * System.out.println(Strong_number(145));
		 * System.out.println(Perfect_number(7));
		 * System.out.println(Automorphic_number(7));
		 * System.out.println(Harshad_number(22));
		 * System.out.println(Abundant_number(18));
		 * Armstrong_number(1000);
		 * Palindrome_number(100);
		 * System.out.println(Power(4,3));
		 * Prime_factor(12);
		 * int decimal=binary_to_decimal(10001);
		 * System.out.println(decimal);
		 * int decimal1=octal_to_decimal(10);
		 * System.out.println(decimal1);
		 * int decimal2=hexa_to_decimal("a");
		 * System.out.println(decimal2);
		 * nthPrime(22);
		 * System.out.println(Palindrome1(195));
		 * System.out.println(isPrime(701));
		 * PrimeNumbers(100,120);
		 * int arr[]= {14,2,5,1,3,4,1};
		 * System.out.println(equilibrium(arr));
		 * Prime_factor(12);
		 * //System.out.println(SpecFibo(2));
		 * //System.out.println(nextPalindrome(2133));
		 * //PrimeNumber(20);
		 * //System.out.println(SpyNumber(1124));
		 * System.out.println(decimal_to_binary(10));
		 * System.out.println(decimal_to_octal(10));
		 * System.out.println(decimal_to_hexa(16));
		 * System.out.println(autobiographical(2020));
		 * BigInteger res=circularSeating(3);
		 * System.out.println(res.multiply(BigInteger.valueOf(2)));
		 * Scanner sc=new Scanner(System.in);
		 * String str=sc.nextLine();
		 * String res=convertString(str);
		 * System.out.println(res);
		 */
		// System.out.println(Armstrong1(8209));
		// System.out.println(sumOfPrime(43));
		Scanner sc = new Scanner(System.in);
		System.out.println("enter s1");
		String s1 = sc.next();
		System.out.println("enter s2");
		String s2 = sc.next();
		System.out.println("enter index");
		int index = sc.nextInt();
		System.out.println(func(index, s1, s2));
		sc.close();
	}
}
