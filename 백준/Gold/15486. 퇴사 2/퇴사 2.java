
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int max = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			T[n] = Integer.parseInt(st.nextToken());
			P[n] = Integer.parseInt(st.nextToken());
		}

		for (int n = 0; n <= N; n++) {
			if (max < dp[n]) {
				max = dp[n];
			}

			if (n + T[n] <= N) {
				dp[n + T[n]] = Math.max(dp[n + T[n]], max + P[n]);
			}
		}
		System.out.println(max);
	}
}
