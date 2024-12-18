

import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] leafCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		for (int n = 0; n < N; n++) {
			list[n] = new ArrayList<Integer>();
		}
		leafCnt = new int[N];

		boolean[] visited = new boolean[N];
		int cnt = 0;
		int startNode = 0;
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				startNode = n;
			} else {
				list[parent].add(n);
			}
		}
		// cnt 는 리프노드의 개수
		cnt = N - cnt;

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		if (M == startNode) {
			System.out.println(0);
		} else {
			System.out.println(tree(startNode));
		}
	}

	public static int tree(int node) {
		int child = 0;
		for (int i = 0; i < list[node].size(); i++) {
			int now = list[node].get(i);
			if (now != M) {
				child += tree(now);
			}
		}
		if (child == 0) {
			child = 1;
		}
		leafCnt[node] = child;
		return child;
	}
}