import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[10010];
		Arrays.fill(dp, 1);
		for (int i = 2; i < 10010; i++) {
			dp[i] += dp[i-2];
		}
		for(int i = 3; i < 10010; i++) {
			dp[i] += dp[i-3];
		}

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int ans = Integer.parseInt(st.nextToken());
			sb.append(dp[ans]+"\n");
		}
		System.out.println(sb.toString());
	}
}