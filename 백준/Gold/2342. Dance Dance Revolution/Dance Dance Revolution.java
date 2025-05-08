import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node> {
		int l;
		int r;
		int num;
		int pow;

		Node(int l, int r, int num, int pow) {
			this.l = l;
			this.r = r;
			this.num = num;
			this.pow = pow;
		}

		@Override
		public int compareTo(Node o) {
			return this.pow - o.pow;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if (now == 0) {
				break;
			}
			list.add(now);
		}
		int size = list.size();
		boolean[][][] visited = new boolean[size + 1][5][5];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		if (list.get(0) != null) {
			pq.add(new Node(list.get(0), 0, 1, 2));
		}

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (visited[node.num][node.l][node.r] == true) {
				continue;
			}
			visited[node.num][node.l][node.r] = true;
			if (node.num == size) {
				System.out.println(node.pow);
				break;
			}
			int nxt = list.get(node.num);
			if (node.l == nxt || node.r == nxt && !visited[node.num + 1][node.l][node.r]) {
				pq.add(new Node(node.l, node.r, node.num + 1, node.pow + 1));
				continue;
			}
			// l 을 움직이기
			if (!visited[node.num + 1][nxt][node.r]) {
				pq.add(new Node(nxt, node.r, node.num + 1, node.pow + nxtStep(node.l, nxt)));
			}
			// r 을 움직이기
			if (!visited[node.num + 1][nxt][node.r]) {
				pq.add(new Node(node.l, nxt, node.num + 1, node.pow + nxtStep(node.r, nxt)));
			}
		}
	}

	public static int nxtStep(int now, int nxt) {
		if (now == 0) {
			return 2;
		}
		if (Math.abs(nxt - now) == 2) {
			return 4;
		}
		return 3;
	}
}