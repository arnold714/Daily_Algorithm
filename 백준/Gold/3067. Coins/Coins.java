import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] coins;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			coins = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				coins[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			dp = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++) {
				Arrays.fill(dp[i], -1);
			}
			int answer = ks(0, 0);
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int ks(int i, int money) {
		// TODO Auto-generated method stub
		if (money == M) {
			return 1;
		}
		if (money > M || i >= coins.length) {
			return 0;
		}
		if (dp[i][money] != -1) {
			return dp[i][money];
		}
		dp[i][money] = ks(i + 1, money) + ks(i, money + coins[i]);
		return dp[i][money];
	}
}
