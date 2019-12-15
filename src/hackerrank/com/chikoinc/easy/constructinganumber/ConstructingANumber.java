package hackerrank.com.chikoinc.easy.constructinganumber;

import java.io.*;
import java.util.*;

public class ConstructingANumber {
	 // Function to returns the arraylist which contains 
    // all the permutation of str 
    public static ArrayList<String> getPermutation(String str) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
  
            // Return an empty arraylist 
            ArrayList<String> empty = new ArrayList<>(); 
            empty.add(""); 
            return empty; 
        } 
  
        // Take first character of str 
        char ch = str.charAt(0); 
  
        // Take sub-string starting from the 
        // second character 
        String subStr = str.substring(1); 
  
        // Recurvise call 
        ArrayList<String> prevResult = getPermutation(subStr); 
  
        // Store the generated permutations 
        // into the resultant arraylist 
        ArrayList<String> Res = new ArrayList<>(); 
  
        for (String val : prevResult) { 
            for (int i = 0; i <= val.length(); i++) { 
            	//if(!Res.contains(val.substring(0, i) + ch + val.substring(i))) {
                    Res.add(val.substring(0, i) + ch + val.substring(i)); 
            	//}
            } 
        } 
  
        // Return the resultant arraylist 
        return Res; 
    } 
	static int[] getAllPossibleCombination(int[] a) {
		StringBuffer stringValue = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			stringValue.append(a[i]);
		}
		int[] allPosibleCombination = new int[stringValue.length() * stringValue.length()];
		List<String> permitationCombination = getPermutation(stringValue.toString());
		for (int i = 0; i < permitationCombination.size(); i++) {
			if (allPosibleCombination.length > i) {
				allPosibleCombination[i] = Integer.parseInt(permitationCombination.get(i));
			}
		}
		return allPosibleCombination;
	}
	// Complete the canConstruct function below.
	static String canConstruct(int[] a) {
		// Return "Yes" or "No" denoting whether you can construct the required number.
		int [] allPosibleCombination = getAllPossibleCombination(a);
		for (int i = 0; i < allPosibleCombination.length; i++) {
			if(allPosibleCombination[i] % 3 == 0) {
				System.out.println(allPosibleCombination[i]);
				return "Yes";
			}
		}
		return "No";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		String result = canConstruct(a);

		System.out.println(result);

		scanner.close();
	}
}
