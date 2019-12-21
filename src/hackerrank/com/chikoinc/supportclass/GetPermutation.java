package hackerrank.com.chikoinc.supportclass;

import java.util.HashSet;
import java.util.Set;

public class GetPermutation {
	private String originalString;
	private Set<String> allPossibleCombinations = new HashSet<String>();
	public GetPermutation(String originalString) {
		this.originalString = originalString;
	}
	public Set<String> getProcessedString(){		
		return getProcessedString(0, originalString.length());		
	}
	public Set<String> getProcessedString(int i, int j){
		String subString = originalString.substring(i, j);
		getAllPossiblePermutation(subString, i, j);
		return allPossibleCombinations;		
	}
	private void getAllPossiblePermutation(String subString, int i, int j) {
		if(i == j) {
			allPossibleCombinations.add(subString);
		} else {
			for (int l = i; l < j; l++) {
				// to swap one char 
				subString = swapTwoGivenIndexCharacters(subString, i, l);
				getAllPossiblePermutation(subString, i+1, j);
				subString = swapTwoGivenIndexCharacters(subString, i, l);
			}
		}
	}
	private String swapTwoGivenIndexCharacters(String subString, int i, int j) {
		char array[] = subString.toCharArray();
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return String.valueOf(array);
	}
}
