

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
	static int N, max = 0;

	public static class Node implements Comparable<Node> {
		int start, end, dist;

		public Node(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		set.add(0);
		set.add(D);
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			if (start > D) {
				continue;
			}
			int end = Integer.parseInt(st.nextToken());
			if (end > D) {
				continue;
			}
			int dist = Integer.parseInt(st.nextToken());
			if (dist > end - start) {
				continue;
			}
			pq.add(new Node(start, end, dist));
			set.add(start);
			set.add(end);
		}
		Integer[] point = set.toArray(new Integer[0]);
		Arrays.sort(point);
		int size = point.length;
		int[] dp = new int[D + 1];
		for (int i = 0; i < size; i++) {
			dp[point[i]] = point[i];
		}
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int start = node.start;
			int end = node.end;
			int dist = node.dist;
			dp[end] = dp[end] < dp[start] + dist ? dp[end] : dp[start] + dist;
			for (int i = 0; i < size; i++) {
				if (point[i] == end) {
					for (int j = i; j < size; j++) {
						dp[point[j]] = dp[point[j]] < dp[point[i]] + point[j] - point[i] ? dp[point[j]]
								: dp[point[i]] + point[j] - point[i];
					}
				}
			}
		}
		System.out.println(dp[D]);
	}
}