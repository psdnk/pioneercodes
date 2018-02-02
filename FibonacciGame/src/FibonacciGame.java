/**
 * @author prasadnaik
 *
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class FibonacciGame {

	int row;
	int col;
	int gameMatrix[][];
	Random random;
	Scanner s;

	public FibonacciGame(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		gameMatrix = new int[row][col];
		random = new Random();
		s = new Scanner(System.in);
		populateRandomCellOnes();
		populateRandomCellOnes();
	}

	public void start() {

		while (true) {
			String key = s.nextLine();

			switch (key) {
			case "w":
				up();
				if (checkEmptyCellPresent())
					populateRandomCellOnes();
				break;
			case "s":
				down();
				if (checkEmptyCellPresent())
					populateRandomCellOnes();
				break;
			case "a":
				left();
				if (checkEmptyCellPresent())
					populateRandomCellOnes();
				break;
			case "d":
				right();
				if (checkEmptyCellPresent())
					populateRandomCellOnes();
				break;

			default:
				break;
			}
		}

	}

	public void up() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < col; i++) {
			q.clear();
			for (int j = 0; j < row; j++) {
				if (gameMatrix[j][i] != 0) {
					q.add(gameMatrix[j][i]);
				}
			}
			int completeCol[] = new int[row];
			int rowIndex = 0;
			while (q.size() >= 2) {
				int x = q.poll();
				//int y = q.poll();
				int y=q.peek();
				if (isFibonacciNumber(x + y)) {
					completeCol[rowIndex++] = x + y;
					q.poll();
				}else {
					completeCol[rowIndex++] = x;
					//completeCol[rowIndex++] = y;
				}
			}
			while (!q.isEmpty()) {
				completeCol[rowIndex] = q.poll();
			}
			for (int j = 0; j < row; j++) {
				gameMatrix[j][i] = completeCol[j];
			}
		}
		System.out.println("After up action:");
		printGameStatus();

	}

	public void down() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < col; i++) {
			q.clear();
			for (int j = row - 1; j >= 0; j--) {
				if (gameMatrix[j][i] != 0) {
					q.add(gameMatrix[j][i]);
				}
			}
			int completeCol[] = new int[row];
			int rowIndex = 0;
			while (q.size() >= 2) {
				int x = q.poll();
				//int y = q.poll();
				int y = q.peek();
				if (isFibonacciNumber(x + y)) {
					completeCol[rowIndex++] = x + y;
					q.poll();
				}else {
					completeCol[rowIndex++] = x;
					//completeCol[rowIndex++] = y;
				}
			}
			while (!q.isEmpty()) {
				completeCol[rowIndex] = q.poll();
			}
			for (int j = row - 1; j >= 0; j--) {
				gameMatrix[j][i] = completeCol[(row - 1) - j];
			}
		}
		System.out.println("After up action:");
		printGameStatus();

	}

	public void left() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			q.clear();
			for (int j = 0; j < col; j++) {
				if (gameMatrix[i][j] != 0)
					q.add(gameMatrix[i][j]);
			}

			int completeRow[] = new int[col];
			int colIndex = 0;
			while (q.size() >= 2) {
				int x = q.poll();
				//int y = q.poll();
				int y = q.peek();
				if (isFibonacciNumber(x + y)) {
					completeRow[colIndex++] = x + y;
					q.poll();
				}else {
					completeRow[colIndex++] = x;
					//completeRow[colIndex++] = y;
				}

			}
			while (!q.isEmpty()) {
				completeRow[colIndex] = q.poll();
			}
			for (int j = 0; j < col; j++) {
				gameMatrix[i][j] = completeRow[j];
			}

		}
		System.out.println("After left action:");
		printGameStatus();
	}

	public void right() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = row - 1; i >= 0; i--) {
			q.clear();
			for (int j = col - 1; j >= 0; j--) {
				if (gameMatrix[i][j] != 0)
					q.add(gameMatrix[i][j]);
			}

			int completeRow[] = new int[col];
			int colIndex = 0;
			while (q.size() >= 2) {
				int x = q.poll();
				//int y = q.poll();
				int y = q.peek();
				if (isFibonacciNumber(x + y)) {
					completeRow[colIndex++] = x + y;
					q.poll();
				}else {
					completeRow[colIndex++] = x;
					//completeRow[colIndex++] = y;
				}

			}
			while (!q.isEmpty()) {
				completeRow[colIndex] = q.poll();
			}
			for (int j = col - 1; j >= 0; j--) {
				gameMatrix[i][j] = completeRow[(col - 1) - j];
			}

		}
		System.out.println("After right action:");
		printGameStatus();

	}

	public boolean checkEmptyCellPresent() {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (gameMatrix[i][j] == 0) {
					return true;
				}
			}
		}
		return false;

	}

	public void populateRandomCellOnes() {
		int rowRandom = random.nextInt(row);
		int colRandom = random.nextInt(col);
		if (gameMatrix[rowRandom][colRandom] == 0) {
			gameMatrix[rowRandom][colRandom] = 1;
			System.out.println("After populating random  :");
			printGameStatus();
			return;
		} else {
			populateRandomCellOnes();
		}

	}

	public void printGameStatus() {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(gameMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	public boolean isFibonacciNumber(int n) {
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

}
