import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];
		for (int n = 1; n <= N; n++) {
			Arrays.fill(dp[n], -1);
		}
		for (int n = 1; n <= N; n++) {
			dp[n][n] = 1;
		}
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			boolean answer = pallin(S, E);
			if(answer == true) {
				sb.append(1+"\n");
			}else {
				sb.append(0+"\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static boolean pallin(int s, int e) {
		// TODO Auto-generated method stub
		if (dp[s][e] == -1) {
			if (arr[s] == arr[e]) {
				boolean inner = true;
				if (s + 1 < e - 1) {
					inner = pallin(s + 1, e - 1);
				}
				if (inner == false) {
					dp[s][e] = 0;
				} else {
					dp[s][e] = 1;
				}
				return inner;
			} else {
				dp[s][e] = 0;
				return false;
			}
		} else if (dp[s][e] == 0) {
			return false;
		} else {
			return true;
		}
	}
}