

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
	static int N, M;
	static int[] arr;
	static int[] ans;
	static StringBuilder sb;
	static String str;
	static Set<String> set;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		set = new HashSet<>();
		arr = new int[N];
		ans = new int[M];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			ans[0] = arr[i];
			recur(i, 1);
		}
		System.out.println(sb.toString());
	}

	private static void recur(int cur, int cnt) {
		if (cnt == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb2.append(ans[i] + " ");
			}
			sb2.append("\n");
			if (set.add(sb2.toString())) {
				sb.append(sb2.toString());
			}
			return;
		}

		if (cur >= N)
			return;

		for (int i = 0; i < N; i++) {
			ans[cnt] = arr[i];
			recur(i, cnt + 1);
		}

	}
}