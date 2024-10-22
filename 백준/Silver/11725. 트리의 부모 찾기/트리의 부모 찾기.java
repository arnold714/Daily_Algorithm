
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		visited[1] = true;
		dfs(1, 0);
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int cur, int prv) {
		// TODO Auto-generated method stub

		for (int i = 0; i < list[cur].size(); i++) {
			int nxt = list[cur].get(i);
			if (!visited[nxt]) {
				visited[nxt] = true;
				parent[nxt] = cur;
				dfs(nxt, cur);
			}
		}
	}

}
