
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int SIZE = 1 << 18;
	static int len = 1 << 17;
	static int[] arr, maxTree, minTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		maxTree = new int[SIZE];
		minTree = new int[SIZE];
		Arrays.fill(minTree, Integer.MAX_VALUE);

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n] = Integer.parseInt(st.nextToken());
		}
		makeTree();
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int ts = Integer.parseInt(st.nextToken());
			int te = Integer.parseInt(st.nextToken());
			int max = getMax(1, 0, len-1, ts-1, te-1);
			int min = getMin(1, 0, len-1, ts-1, te-1);
			sb.append(min + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void makeTree() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			maxTree[len + i] = arr[i];
			minTree[len + i] = arr[i];
		}
		for (int i = len - 1; i >= 1; i--) {
			maxTree[i] = Math.max(maxTree[2 * i], maxTree[2 * i + 1]);
			minTree[i] = Math.min(minTree[2 * i], minTree[2 * i + 1]);
		}
	}

	private static int getMax(int idx, int s, int e, int ts, int te) {
		// TODO Auto-generated method stub
		if (e < ts || s > te)
			return Integer.MIN_VALUE;
		else if (ts <= s && e <= te)
			return maxTree[idx];
		int mid = (s + e) / 2;
		int l = getMax(2 * idx, s, mid, ts, te);
		int r = getMax(2 * idx + 1, mid + 1, e, ts, te);
		return Math.max(l, r);
	}

	private static int getMin(int idx, int s, int e, int ts, int te) {
		// TODO Auto-generated method stub
		if (e < ts || s > te)
			return Integer.MAX_VALUE;
		else if (ts <= s && e <= te)
			return minTree[idx];
		int mid = (s + e) / 2;
		int l = getMin(2 * idx, s, mid, ts, te);
		int r = getMin(2 * idx + 1, mid + 1, e, ts, te);
		return Math.min(l, r);
	}
}
