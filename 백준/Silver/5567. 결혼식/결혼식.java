
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer;
	static boolean flag = true;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static class Node {
		int val;
		int friend;

		Node(int val, int friend) {
			this.val = val;
			this.friend = friend;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int n = 1; n <= N; n++) {
			list[n] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		answer = -1;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			int val = node.val;
			int friend = node.friend;
			if (visited[val]) {
				continue;
			}
			visited[val]=true;
			answer++;
			if (friend<2) {
				for (int i = 0; i < list[val].size(); i++) {
					int nxt = list[val].get(i);
					if(!visited[nxt]) {
						q.add(new Node(nxt,friend+1));
					}
				}
			}
		}
		System.out.println(answer);
	}

}
