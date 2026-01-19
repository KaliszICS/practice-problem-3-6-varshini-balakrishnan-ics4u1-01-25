public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String [][] arr) {
		int curRow = arr.length - 1;
		int curCol = 0;
		int noOfMoves = 0;
		return minMovesHelper(arr, curRow, curCol, noOfMoves);
	}
	public static int minMovesHelper(String[][] arr, int curRow, int curCol, int noOfMoves) {
		if (curRow < 0 || curRow >= arr.length || curCol < 0 || curCol >= arr[0].length) {
			return -1;
		}
		if (arr[curRow][curCol].equals("*")) {
			return -1;
		}
		if (arr[curRow][curCol].equals("F")) {
			return noOfMoves;
		}
		if (arr[curRow][curCol].equals("V")) {
			return -1;
		}
		String temp = arr[curRow][curCol];
		arr[curRow][curCol] = "V";
		int right = minMovesHelper(arr, curRow, curCol + 1, noOfMoves + 1);
		int up = minMovesHelper(arr, curRow - 1, curCol, noOfMoves + 1);
		int left = minMovesHelper(arr, curRow, curCol -1, noOfMoves + 1);
		int down = minMovesHelper (arr, curRow + 1, curCol, noOfMoves + 1);
		arr[curRow][curCol] = temp;
		int min = -1;
		if (right != -1) min = right;
		if (up != -1 && (min == -1 || up < min)) min = up;
		if (left != -1 && (min == -1 || left < min)) min = left;
		if (down != -1 && (min == -1 || down < min)) min = down;
		return min;
	}
	public static int noOfPaths(String[][] arr) {
		int curRow = arr.length - 1;
		int curCol = 0;
		return pathsHelper(arr, curRow, curCol);
	}

	public static int pathsHelper(String[][]arr, int curRow, int curCol) {
		if (curRow < 0 || curRow >= arr.length || curCol < 0 || curCol >= arr[0].length) {
			return 0;
		}
		if (arr[curRow][curCol].equals("F")) {
			return 1;
		}
		if (arr[curRow][curCol].equals("*")) {
			return 0;
		}
		if (arr[curRow][curCol].equals("V")) {
			return 0;
		}
		String temp = arr[curRow][curCol];
		arr[curRow][curCol] = "V";
		int right = pathsHelper(arr, curRow, curCol + 1);
		int up = pathsHelper(arr, curRow - 1, curCol);
		int left = pathsHelper(arr, curRow, curCol -1);
		int down = pathsHelper(arr, curRow + 1, curCol);
		arr[curRow][curCol] = temp;
		return right + up + left + down;
	}

	
}
