package hackerrank.com.chikoinc.easy.impressingtheboss;

import java.io.*;
import java.util.*;

public class ImpressingTheBoss {

    /*
     * Complete the canModify function below.
     */
    static String canModify(int[] a) {
        /*
         * Write your code here.
         */
    	int alreadyModified = 0;
    	
    	for (int i = 0; i < a.length - 2; i++) {
			if(a[i] > a[i+1]) {
				if(alreadyModified == 1) {
					alreadyModified = -1;
					a[i+1] = a[i+2] - 1;
					break;
				}
				alreadyModified = 1;
			}
		}
    	return alreadyModified == 1 ? "Yes" : "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = 2;

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr]);
                a[aItr] = aItem;
            }

            String result = canModify(a);

            System.out.println(result);
        }
        scanner.close();
    }
}
