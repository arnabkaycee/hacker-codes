package interview.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpiralMatrix {

	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = takeArrayInput(m, n);
		printSpiral(arr);
	}

	public static void printSpiral(int[][] arr) {
		int m, n;
		m = arr.length;
		n = arr[0].length;
		int lcl = 0;
		int url = 0;
		int ucl = n - 1;
		int lrl = m - 1;
		while (true) {
			if (checkEnd(url, lrl, lcl, ucl))
				break;
			
			printL2R(arr, lcl, ucl, url++);
			
			if (checkEnd(url, lrl, lcl, ucl))
				break;
			
			printT2B(arr, url, lrl, ucl--);
			
			if (checkEnd(url, lrl, lcl, ucl))
				break;

			printR2L(arr, ucl, lcl, lrl--);
			
			if (checkEnd(url, lrl, lcl, ucl))
				break;
			
			printB2T(arr, lrl, url, lcl++);
		}

	}

	public static boolean checkEnd(int url, int lrl, int lcl, int ucl) {
		return (url > lrl || lcl > ucl);
	}

	public static void printL2R(int[][] arr, int lcl, int ucl, int row) {
		for (int k = lcl; k <= ucl; k++) {
			System.out.print(arr[row][k] + " ");
		}
	}

	public static void printR2L(int[][] arr, int ucl, int lcl, int row) {
		for (int k = ucl; k >= lcl; k--) {
			System.out.print(arr[row][k] + " ");
		}
	}

	public static void printT2B(int[][] arr, int url, int lrl, int col) {
		for (int k = url; k <= lrl; k++) {
			System.out.print(arr[k][col] + " ");
		}
	}

	public static void printB2T(int[][] arr, int lrl, int url, int col) {
		for (int k = lrl; k >= url; k--) {
			System.out.print(arr[k][col] + " ");
		}
	}

	public static int[][] takeArrayInput(int m, int n) throws IOException {
		int[][] arr = new int[m][n];
		//br = new BufferedReader(new InputStreamReader(System.in));
		int rowCounter = 0, colCounter;
		String line;
		while (rowCounter < m) {
			line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			colCounter = 0;
			while (colCounter < n) {
				arr[rowCounter][colCounter] = Integer.parseInt(st.nextToken());
				++colCounter;
			}
			++rowCounter;
		}
		return arr;
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}
