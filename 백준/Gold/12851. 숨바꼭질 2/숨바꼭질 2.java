

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main{
	static int answer;
	static int min;

	public static class Node {
		int point, val;

		public Node(int point, int val) {
			this.point = point;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [point=" + point + ", val=" + val + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];
		for (int i = 0; i <= 100000; i++) {
			arr[i] = -1;
		}
		answer = 1;
		min = Integer.MAX_VALUE;
		
		arr[N] = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			int point = node.point;
			int val = node.val;
			if (point == K) {
				if (val == min) {
					answer++;
				} else if (val < min) {
					min = val;
					answer = 1;
				}
			}

			if (point * 2 >= 0 && point * 2 <= 100000) {
				if (arr[point * 2] == -1 || arr[point * 2] >= val + 1) {
					arr[point * 2] = val + 1;
					q.add(new Node(point * 2, val + 1));
				}
			}

			if (point - 1 >= 0 && point - 1 <= 100000) {
				if (arr[point - 1] == -1 || arr[point - 1] >= val + 1) {
					arr[point - 1] = val + 1;
					q.add(new Node(point - 1, val + 1));
				}
			}

			if (point + 1 >= 0 && point + 1 <= 100000) {
				if (arr[point + 1] == -1 || arr[point + 1] >= val + 1) {
					arr[point + 1] = val + 1;
					q.add(new Node(point + 1, val + 1));
				}
			}
		}
		System.out.println(arr[K]);
		System.out.println(answer);
	}

}
