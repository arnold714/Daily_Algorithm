

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
	static boolean[] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list = new ArrayList<>();
			visited[i] = true;
			list.add(i);
			recur(i, 1);
			visited[i] = false;
		}
	}

	private static void recur(int cur, int cnt) {
		// TODO Auto-generated method stub
		if (cnt == M) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		if (cur > N)
			return;

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(i);
				recur(cur, cnt + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}

}