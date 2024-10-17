

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static int N, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = board[0][0];
		max = dp[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + board[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + board[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j-1], dp[i-1][j]) + board[i][j];
				}
				if(i==N-1) {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}