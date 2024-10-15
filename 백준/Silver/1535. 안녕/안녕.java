

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
	static int N;
	static int[] hp, happy;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		hp = new int[N];
		happy = new int[N];
		dp = new int[21][2100];
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 2100; j++) {
				dp[i][j] = -1;
			}
		}
		for (int n = 0; n < N; n++) {
			hp[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			happy[n] = Integer.parseInt(st.nextToken());
		}
		System.out.println(recur(0,0));
	}

	// cur: 현재 사람 번호 , h:현재 hp
	public static int recur(int cur, int h) {
		if (h >= 100)
			return -100;

		if (cur == N) {
			return 0;
		}

		if (dp[cur][h] != -1) {
			return dp[cur][h];
		}

		int a = recur(cur + 1, h + hp[cur]) + happy[cur];
		int b = recur(cur + 1, h);

		dp[cur][h] = Math.max(a, b);
		return dp[cur][h];
	}
}