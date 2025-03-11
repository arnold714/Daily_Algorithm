
import java.io.*;
import java.util.*;

public class Main {
	static int[][] tree;
	static boolean[] visited;
	static int answer = 0;
	static int cnt = 0;
	static int N;
	static boolean finished = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tree = new int[N + 1][2];
		visited = new boolean[N + 1];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			tree[x][0] = Integer.parseInt(st.nextToken());
			tree[x][1] = Integer.parseInt(st.nextToken());
		}

		dfs(1, 0);
		System.out.println(answer);
	}

	private static void dfs(int cur, int dir) {
		// TODO Auto-generated method stub
		if (!visited[cur]) {
			visited[cur] = true;
			cnt++;
		}

		int[] nxt = tree[cur];

		if (nxt[0] != -1 && !visited[nxt[0]]) {
			answer++;
			dfs(nxt[0], dir - 1);
			answer++;
		}

		if (nxt[1] != -1 && !visited[nxt[1]]) {
			answer++;
			dfs(nxt[1], dir < 0 ? dir + 1 : 0);
			if (cnt == N && dir == 0) {
				finished = true;
			}
			if (!finished) {
				answer++;
			}
		}
	}
}
