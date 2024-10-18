
import java.util.*;
import java.io.*;

public class Main {

	public static class Node implements Comparable<Node> {
		int start, end, cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		ArrayList<Node>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Node(start, end, cost));
		}

		st = new StringTokenizer(br.readLine());
		int sNode = Integer.parseInt(st.nextToken());
		int eNode = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> q = new PriorityQueue<>();
		visited[sNode] = true;

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < list[sNode].size(); i++) {
			q.add(list[sNode].get(i));
		}

		arr[sNode] = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int start = node.start;
			int end = node.end;
			int cost = node.cost;
			if (visited[end]) {
				continue;
			}
			arr[end] = arr[end] < cost ? arr[end] : cost;
			visited[end] = true;
			for (int i = 0; i < list[end].size(); i++) {
				q.add(new Node(end, list[end].get(i).end, list[end].get(i).cost + cost));
			}
		}
		System.out.println(arr[eNode]);
	}

}
