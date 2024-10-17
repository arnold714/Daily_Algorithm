

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
	static int N, max = 0;
	static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			LIS(i);
		}
		System.out.println(max);
	}

	private static void LIS(int cur) {
		// TODO Auto-generated method stub
		int num = arr[cur];

		if (dp[cur] == 0) {
			dp[cur] = 1;
		}

		for (int i = 0; i < cur; i++) {
			if (arr[i] < arr[cur]) {
				dp[cur] = Math.max(dp[cur], dp[i] + 1);
			}
		}
		max = Math.max(max, dp[cur]);
	}
}