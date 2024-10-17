

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
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] board = new int[2][N];
			int[][] dp = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					board[i][n] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = board[0][0];
			dp[1][0] = board[1][0];
			max = Math.max(dp[0][0], dp[1][0]);
			
			if (N > 1) {
				dp[0][1] = dp[1][0] + board[0][1];
				dp[1][1] = dp[0][0] + board[1][1];
				max = Math.max(dp[0][1], dp[1][1]);
			}
			
			for (int i = 2; i < N; i++) {
				dp[0][i] = Math.max(dp[0][i - 2], Math.max(dp[1][i - 2], dp[1][i - 1]))+board[0][i];
				max = Math.max(max, dp[0][i]);
				
				dp[1][i] = Math.max(dp[1][i - 2], Math.max(dp[0][i - 2], dp[0][i - 1]))+board[1][i];
				max = Math.max(max, dp[1][i]);
			}
			System.out.println(max);
		}

	}
}