import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int point;
		int cnt;

		Node(int point, int cnt) {
			this.point = point;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> ladder = new HashMap<Integer, Integer>();
		for (int n = 0; n < N + M; n++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ladder.put(S, E);
		}
		int[] dp = new int[101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(1, 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			int point = node.point;
			int cnt = node.cnt;
			if (dp[point] > cnt) {
				dp[point] = cnt;
				for (int i = 6; i >= 1; i--) {
					int nxt = point + i;
					if (ladder.containsKey(nxt)) {
						nxt = ladder.get(nxt);
					}
					if (nxt > 100) {
						continue;
					}
					if (dp[nxt] > cnt + 1) {
						q.add(new Node(nxt, cnt + 1));
					}
				}
			}
		}
		System.out.println(dp[100]);
	}
}