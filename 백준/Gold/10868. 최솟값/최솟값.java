
import java.util.*;
import java.io.*;

public class Main{
	static int SIZE = 1 << 21;
	static int len = 1 << 20;
	static int N, M;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[SIZE];
		for (int i = 0; i < len; i++) {
			tree[len + i] = Integer.MAX_VALUE;
		}
		for (int n = 0; n < N; n++) {
			tree[len + n] = Integer.parseInt(br.readLine());
		}

		makeTree();

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int ts = Integer.parseInt(st.nextToken());
			int te = Integer.parseInt(st.nextToken());
			sb.append(get(1, 0, len - 1, ts - 1, te - 1)+"\n");
		}
		System.out.println(sb.toString());
	}

	public static int get(int idx, int s, int e, int ts, int te) {
		if (e < ts || s > te)
			return Integer.MAX_VALUE;
		else if (e <= te && s >= ts)
			return tree[idx];

		int mid = (s + e) / 2;
		int l = get(2 * idx, s, mid, ts, te);
		int r = get(2 * idx + 1, mid + 1, e, ts, te);
		return l < r ? l : r;
	}

	public static void makeTree() {
		for (int i = len - 1; i >= 1; i--) {
			tree[i] = tree[2 * i] < tree[2 * i + 1] ? tree[2 * i] : tree[2 * i + 1];
		}
	}
}