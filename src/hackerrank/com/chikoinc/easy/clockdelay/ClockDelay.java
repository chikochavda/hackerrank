package hackerrank.com.chikoinc.easy.clockdelay;

import java.io.*;
import java.util.*;

public class ClockDelay {

    // Complete the lagDuration function below.
    static int lagDuration(int h1, int m1, int h2, int m2, int k) {
    	int totalLaggedHours = (h2 - h1) - k;
    	int totalLaggedMinutes = m2 - m1;
    	int hourConvertedMinutes = totalLaggedHours * 60;
    	// Return an integer denoting the duration of time in minutes by which the clock has been lagging.
    	int totalLag = hourConvertedMinutes + totalLaggedMinutes;
		return totalLag < 0 ? totalLag * -1 : totalLag;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] h1M1H2M2 = scanner.nextLine().split(" ");

            int h1 = Integer.parseInt(h1M1H2M2[0]);

            int m1 = Integer.parseInt(h1M1H2M2[1]);

            int h2 = Integer.parseInt(h1M1H2M2[2]);

            int m2 = Integer.parseInt(h1M1H2M2[3]);

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = lagDuration(h1, m1, h2, m2, k);

            System.out.println(String.valueOf(result));
        }


        scanner.close();
    }
}
