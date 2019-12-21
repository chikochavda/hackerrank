package hackerrank.com.chikoinc.supportclass;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorNumbers {
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
				if(integer * integer2 == n || integer == n) {
					if(!primeFactorNumber.contains(integer)) {
						primeFactorNumber.add(integer);	
					}
				}
			}	
		}
		return primeFactorNumber;
	}

	public static void main(String[] args) {
        List<Integer> models = new ArrayList<>();

        models = 		getPrimFactorNumberOfNumber(8);
        for (Integer integer : models) {
			System.out.println(integer);
		}
	}
}
