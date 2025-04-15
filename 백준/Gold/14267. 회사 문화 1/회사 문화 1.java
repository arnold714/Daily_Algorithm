import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] compliment, answer;
	static ArrayList<Integer>[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		compliment = new int[N + 1];
		answer = new int[N + 1];
		parent = new ArrayList[N + 1];
		for (int n = 1; n <= N; n++) {
			parent[n] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			int nxt = Integer.parseInt(st.nextToken());
			if (nxt == -1)
				continue;
			parent[nxt].add(n);
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			compliment[i] += w;
		}
		dfs(1, compliment[1]);
		for (int n = 1; n <= N; n++) {
			System.out.print(answer[n] + " ");
		}
	}

	private static void dfs(int prv, int weight) {
		// TODO Auto-generated method stub
		answer[prv] = weight;
		int num = prv;
		for (int i = 0; i < parent[num].size(); i++) {
			int nxt = parent[num].get(i);
			dfs(nxt, weight + compliment[nxt]);
		}
	}
}
