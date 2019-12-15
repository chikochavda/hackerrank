package hackerrank.com.chikoinc.easy.hangingposters;

import java.io.*;
import java.util.*;

class Result {
	public static int solveLadderHeightForEachPosterAndPoint(int personHeight, int wallPoint, int posterLength) {
		float positonForBolted = wallPoint - (posterLength/4);
		float ladderSize = positonForBolted - personHeight;
		return Math.round(ladderSize);
	}
	/*
	 * Complete the 'solve' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER h 2. INTEGER_ARRAY wallPoints 3. INTEGER_ARRAY lengths
	 */

	public static int solve(int personHeight, List<Integer> wallPointsToHangPoster, List<Integer> posterLength) {
		int maxHeightLadderNeededToHangPoster = 0;
		for (int i = 0; i < wallPointsToHangPoster.size(); i++) {
			int wallPoint = wallPointsToHangPoster.get(i);
			int posterHeight = posterLength.get(i);
			int ladderHeight = solveLadderHeightForEachPosterAndPoint(personHeight, wallPoint, posterHeight);
			if (ladderHeight > maxHeightLadderNeededToHangPoster) {
				maxHeightLadderNeededToHangPoster = ladderHeight;
			}

		}

		return maxHeightLadderNeededToHangPoster;
	}

}

public class HangingPosters {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int h = Integer.parseInt(firstMultipleInput[1]);

		String[] wallPointsTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> wallPoints = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int wallPointsItem = Integer.parseInt(wallPointsTemp[i]);
			wallPoints.add(wallPointsItem);
		}

		String[] lengthsTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> lengths = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int lengthsItem = Integer.parseInt(lengthsTemp[i]);
			lengths.add(lengthsItem);
		}

		int answer = Result.solve(h, wallPoints, lengths);

		System.out.println(answer);
		bufferedReader.close();
	}
}
