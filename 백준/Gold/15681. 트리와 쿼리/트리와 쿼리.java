
import java.io.*;
import java.util.*;

public class Main {
	static int N, R, Q;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] subTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		subTree = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int n = 1; n <= N; n++) {
			list[n] = new ArrayList<Integer>();
		}

		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		tree(R, R);
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(subTree[Integer.parseInt(st.nextToken())]);
		}
	}

	private static void tree(int cur, int prv) {
		// TODO Auto-generated method stub
		int answer = 0;
		for (int i = 0; i < list[cur].size(); i++) {
			int nxt = list[cur].get(i);
			if (nxt != prv) {
				answer++;
			}
		}
		if (answer == 0) {
			subTree[cur] = 1;
			return;
		}
		subTree[cur] += 1;
		for (int i = 0; i < list[cur].size(); i++) {
			int nxt = list[cur].get(i);
			if (nxt != prv) {
				tree(nxt, cur);
				subTree[cur] += subTree[nxt];
			}
		}
	}
}