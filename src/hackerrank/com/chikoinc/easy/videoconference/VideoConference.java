package hackerrank.com.chikoinc.easy.videoconference;

import java.io.*;
import java.util.*;

class Result {
	private static int nameCounter = 2;

	public static <T> List<T> convertSetToList(Set<T> set) {
		// create a list from Set
		List<T> list = new ArrayList<>(set);
		// return the list
		return list;
	}

	public static String extractPrefix(String orginalString, String alreadyExtractedPrefix) {
		String substring = alreadyExtractedPrefix.length() >= orginalString.length() ? orginalString : orginalString.substring(0, alreadyExtractedPrefix.length() + 1);

		if (orginalString.length() <= alreadyExtractedPrefix.length()) {
			substring = orginalString + " " + nameCounter;
			nameCounter++;
		}
		return substring;
	}
	public static String checkAlreadySolvedNames(String newName, List<String> solvedOrginalNames) {
		String alreadyExistedName = "";
		for (String string : solvedOrginalNames) {
			if(string.startsWith(newName) && alreadyExistedName.length() <= string.length()) {
				alreadyExistedName = string;
			}
		}
		return alreadyExistedName;
	}
	public static Set<String> getPrefixToMakeSureSolvedIsNotConflicated(Set<String> solvedNames, String originalName,
			String prefix) {
		String extractedSubString = extractPrefix(originalName, prefix);

		if (!solvedNames.contains(extractedSubString)) {
			solvedNames.add(extractedSubString);
			return solvedNames;
		} else {
			return getPrefixToMakeSureSolvedIsNotConflicated(solvedNames, originalName, extractedSubString);
		}
	}
	/*
	 * Complete the 'solve' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING_ARRAY names as parameter.
	 */

	public static List<String> solve(List<String> names) {
		// Write your code here
		Set<String> solvedNames = new HashSet<String>();
		
		List<String> solvedOrginalNames = new ArrayList<String>();
		for (String string : names) {
			nameCounter = 2;
			String basicPrefix = checkAlreadySolvedNames(string, solvedOrginalNames);
			solvedNames = getPrefixToMakeSureSolvedIsNotConflicated(solvedNames, string, basicPrefix);
			solvedOrginalNames.add(string);
		}
		return convertSetToList(solvedNames);
	}
}

public class VideoConference {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> names = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String namesItem = bufferedReader.readLine();
			names.add(namesItem);
		}

		List<String> res = Result.solve(names);

		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i));

			if (i != res.size() - 1) {
				System.out.print("\n");
			}
		}

		System.out.println();
		bufferedReader.close();
	}
}
