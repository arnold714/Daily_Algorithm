

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Node implements Comparable<Node> {
		int x, y, val, timer, endtime;
		boolean activate;

		public Node(int x, int y, int val, int timer, int endtime, boolean activate) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
			this.timer = timer;
			this.endtime = endtime;
			this.activate = activate;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.endtime == o.endtime) {
				return this.val > o.val ? -1 : 1;
			}
			return this.endtime - o.endtime;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", val=" + val + ", timer=" + timer + ", endtime=" + endtime
					+ ", activate=" + activate + "]";
		}

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] board = new int[N + 2 * K][M + 2 * K];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					board[K + n][K + m] = Integer.parseInt(st.nextToken());
					if (board[K + n][K + m] != 0) {
						pq.add(new Node(K + n, K + m, board[K + n][K + m], board[K + n][K + m], 0, false));
					}
				}
			}

			while (!pq.isEmpty()) {
				if (pq.peek().endtime == K) {
//					System.out.println(pq.toString());
					System.out.println("#" + tc + " " + pq.size());
					break;
				}
				Node node = pq.poll();
				int x = node.x;
				int y = node.y;
				int val = node.val;
				int timer = node.timer;
				int endtime = node.endtime;
				boolean activate = node.activate;

				if (!activate) {
					if (timer == 1) {
						pq.add(new Node(x, y, val, 0, endtime + 1, true));
					} else if (timer > 1) {
						pq.add(new Node(x, y, val, timer - 1, endtime + 1, false));
					}
				} else if (timer == 0) {
					for (int d = 0; d < 4; d++) {
						if (board[x + dx[d]][y + dy[d]] == 0) {
							board[x + dx[d]][y + dy[d]] = val;
							pq.add(new Node(x + dx[d], y + dy[d], val, val, endtime + 1, false));
						}
					}
					if (val != 1) {
						pq.add(new Node(x, y, val, timer + 1, endtime + 1, true));
					}
				} else {
					if(timer!=val-1) {
						pq.add(new Node(x, y, val, timer + 1, endtime + 1, true));
					}
				}
			}
//			for (int i = 0; i < N + 2 * K; i++) {
//				for (int j = 0; j < M + 2 * K; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
		}

	}
}