import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] coins = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) {
				coins[n] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (j - coins[i] > 0) {
						dp[j] = dp[j] + dp[j - coins[i]];
					} else if (j - coins[i] == 0) {
						dp[j]++;
					}
				}
			}
			System.out.println(dp[M]);
		}
	}
}
