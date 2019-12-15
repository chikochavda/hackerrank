package hackerrank.com.chikoinc.easy.combodeal;

import java.io.*;
import java.util.*;

public class ComboDeal {

	// Complete the profit function below.
	static int profit(int b, int s, int c) {
		// Return the fixed profit.
		int remaingingAmount = (b + s) - c;
		return remaingingAmount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] bsc = scanner.nextLine().split(" ");

		int b = Integer.parseInt(bsc[0]);

		int s = Integer.parseInt(bsc[1]);

		int c = Integer.parseInt(bsc[2]);

		int result = profit(b, s, c);

		System.out.println("Result >> " + result);

		scanner.close();
	}
}
