package hackerrank.com.chikoinc.easy.wenddyandbobissue;



public class Solution {
    public static int findAdjacentIndexwhichCanBeRemoved(String a, char gameChangerName){
		char array[] = a.toCharArray();
		int sameCount = 0;
		for (int i = 0; i < array.length-1; i++) {
			
			if((array[i] == 'w' || array[i] == 'b') && (array[i+1] == 'w' || array[i+1] == 'b')) {
				// incase we have any other color
				return -2;
			}
			if(array[i] == array[i+1] && array[i] == gameChangerName) {
				sameCount++;
			} else {
				sameCount = 0;
			}
			if(sameCount == 2) {
				return i;
			}
		}
		return -1;
    }
    /*
     * Complete the 'gameWinner' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING colors as parameter.
     */
    static boolean turn = false;
    public static String gameWinner(String colors) {
    // Write your code here
    	
    	turn = !turn;
    	char name = turn ? 'w' : 'b';
    	
        int indexToBeRemoved = findAdjacentIndexwhichCanBeRemoved(colors, name);
        if (indexToBeRemoved == -2) {
			return "";
		}
        if (indexToBeRemoved == -1) {
			return name != 'w' ? "wendy" : "Bob";
		} else {
			StringBuilder sb = new StringBuilder(colors);
			sb.deleteCharAt(indexToBeRemoved);
			colors = sb.toString();
			return gameWinner(colors);
		}
    }
    public static void main(String[] args) {
		Solution l = new Solution();
		System.out.println(l.gameWinner("xhskwwwbbbwjsnbwwwbbb"));
	}
}

