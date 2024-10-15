
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

public class Main {
	static int N, K;
	static ArrayList<int[]> list;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 부피, 가치
		list = new ArrayList<>();
		dp = new int[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				dp[i][j] = -1;
			}
		}
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			list.add(new int[] { W, V });
		}
		System.out.println(recur(0, 0));
	}

	public static int recur(int cur, int w) {
		if (w > K)
			return -1000;
		if (cur == N)
			return 0;

		if (dp[cur][w] != -1)
			return dp[cur][w];

		int a = recur(cur + 1, w + list.get(cur)[0]) + list.get(cur)[1];
		int b = recur(cur + 1, w);

		dp[cur][w] = Math.max(a, b);

		return dp[cur][w];
	}
}