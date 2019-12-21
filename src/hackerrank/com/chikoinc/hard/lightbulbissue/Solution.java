package hackerrank.com.chikoinc.hard.lightbulbissue;
import java.io.*;
import java.util.*;

class Result {
	/*
	 * Complete the 'lightBulbs' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY states 2. INTEGER_ARRAY numbers
	 */

	public static List<Integer> lightBulbs(List<Integer> states, List<Integer> numbers) {
		// Write your code here
		for (Integer integer : numbers) {
			List<Integer> primeNumbers = getPrimFactorNumberOfNumber(integer);
			for (Integer primeNumber : primeNumbers) {
				for (int i = 0; i < states.size(); i++) {
					if ((i + 1) % primeNumber == 0) {
						states.set(i, states.get(i) == 1 ? 0 : 1);
					}
				}
			}
		}
		return states;
	}

	static boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	static List<Integer> getPrimFactorNumberOfNumber(int n) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i))
				numbers.add(i);
		}
		List<Integer> primeFactorNumber = new ArrayList<Integer>();

		for (Integer integer : numbers) {
			for (Integer integer2 : numbers) {
				if (integer * integer2 == n || integer == n) {
					if (!primeFactorNumber.contains(integer)) {
						primeFactorNumber.add(integer);
					}
				}
			}
		}
		return primeFactorNumber;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {

		ArrayList<Integer> obj = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1));
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(3, 3, 8, 6));
		List<Integer> result = Result.lightBulbs(obj, numbers);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}
}
