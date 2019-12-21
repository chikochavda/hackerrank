package hackerrank.com.chikoinc.supportclass;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PermutationTestCase {

	@Test
	void test() {
		GetPermutation getPermutation = new GetPermutation("abc");
		Set<String> allPossibleCombination = getPermutation.getProcessedString();
		for (Iterator<String> iterator = allPossibleCombination.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
