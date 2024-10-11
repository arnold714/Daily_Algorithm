
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int baby = 2;
	static int eat = 0;
	static int fish = 0;
	static int[] now;
	static int[][] board;
	static int N, timer;

	static class Node implements Comparable<Node>{
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.time == o.time) {
				if(this.x == o.x) {
					return this.y - o.y;
				}else {
					return this.x - o.x;
				}
			}
			return this.time - o.time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		// 물고기의 무게는 6까지
		timer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					now = new int[] { i, j };
					board[i][j] = 0;
				} else if (board[i][j] != 0) {
					fish++;
				}
			}
		}
		play();
		System.out.println(timer);
	}

	private static void play() {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(now[0], now[1], 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			if(visited[node.x][node.y]) {
				continue;
			}
			visited[node.x][node.y] = true;
			if (board[node.x][node.y] != 0 && board[node.x][node.y] < baby) {
				eat++;
				if (eat == baby) {
					eat = 0;
					baby++;
				}
				q.clear();
				visited = new boolean[N][N];
				board[node.x][node.y] = 0;
				timer = node.time;
				q.add(new Node(node.x, node.y, node.time));
				fish--;
				if (fish == 0) {
					break;
				}
			} else {
				for (int d = 0; d < 4; d++) {
					int next_x = node.x + dx[d];
					int next_y = node.y + dy[d];
					if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < N && !visited[next_x][next_y]) {
						if (board[next_x][next_y] <= baby) {
							q.add(new Node(next_x, next_y, node.time + 1));
						}
					}
				}
			}

		}
	}
}