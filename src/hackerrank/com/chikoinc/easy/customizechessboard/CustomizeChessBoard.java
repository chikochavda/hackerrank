package hackerrank.com.chikoinc.easy.customizechessboard;

import java.io.*;

public class CustomizeChessBoard {

	// Complete the solve function below.
	static String solve(Integer[][] board, Integer size) {
		Boolean boardValidityV = true;
		Boolean boardValidityH = true;
		/**
		 * first we check it row by row
		 */
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (board[i][j] == board[i][j + 1]) {
					boardValidityV = false;
					break;
				}
			}
		}
		/**
		 * if it's working row by row then column by column
		 */
		if (boardValidityV) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - 1; j++) {
					if (board[j][i] == board[j + 1][i]) {
						boardValidityH = false;
						break;
					}
				}
			}
		}

		return boardValidityV && boardValidityH ? "Yes" : "No";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			int n = Integer.parseInt(bufferedReader.readLine().trim());

			Integer allItems[][] = new Integer[n][n];
			for (int i = 0; i < n; i++) {
				String[] boardRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				for (int j = 0; j < n; j++) {
					int boardItem = Integer.parseInt(boardRowTempItems[j]);
					allItems[i][j] = boardItem;
				}
			}

			String result = solve(allItems, n);

			System.out.println(result);
		}

		bufferedReader.close();
	}
}
