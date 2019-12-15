package hackerrank.com.chikoinc.medium.cloudyday;

import java.io.*;
import java.util.*;

public class CloudyDay {
	
	static int getRemovedCloudIndex(long townPositions, long population, long[] allCloudPosition, long[] allCloudSize) {
		int removedIndex = -1;
		for (int i = 0; i < allCloudPosition.length; i++) {
			if (allCloudPosition[i] + allCloudSize[i] >= townPositions && allCloudPosition[i] - allCloudSize[i] <= townPositions) {
				removedIndex = i;
			}
		}
		return removedIndex;
	}

    // Complete the maximumPeople function below.
    static long maximumPeople(long[] population, long[] townPosition, long[] cloudPositions, long[] cloudSizes) {
        // Return the maximum number of people that will be in a sunny town after removing exactly one cloud.
    	long maxAffectedPopulation  = 0;
    	long nonCoveredPopulation = 0;
    	for (int i = 0; i < townPosition.length; i++) {
			int index = getRemovedCloudIndex(townPosition[i], population[i], cloudPositions, cloudSizes);
			if(index == -1) {
				nonCoveredPopulation += population[i];						
			} else {
				if(maxAffectedPopulation <= population[i]) {
					maxAffectedPopulation = population[i];
				}
			}
		}
    	return nonCoveredPopulation + maxAffectedPopulation;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] p = new long[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long pItem = Long.parseLong(pItems[i]);
            p[i] = pItem;
        }

        long[] x = new long[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long xItem = Long.parseLong(xItems[i]);
            x[i] = xItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] y = new long[m];

        String[] yItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long yItem = Long.parseLong(yItems[i]);
            y[i] = yItem;
        }

        long[] r = new long[m];

        String[] rItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long rItem = Long.parseLong(rItems[i]);
            r[i] = rItem;
        }

        long result = maximumPeople(p, x, y, r);

        System.out.println(String.valueOf(result));


        scanner.close();
    }
}
