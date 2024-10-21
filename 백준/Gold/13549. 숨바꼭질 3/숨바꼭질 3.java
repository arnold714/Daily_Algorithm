
import java.io.*;
import java.util.*;

public class Main {

	public static class Node {
		int point, val;

		public Node(int point, int val) {
			this.point = point;
			this.val = val;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];
		Arrays.fill(arr, -1);  // 배열을 -1로 초기화
		arr[N] = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			int point = node.point;
			int val = node.val;

			// 순간이동
			if (point * 2 <= 100000 && (arr[point * 2] == -1 || arr[point * 2] > val)) {
				arr[point * 2] = val;
				q.add(new Node(point * 2, val));
			}
			
			// 뒤로 이동
			if (point - 1 >= 0 && (arr[point - 1] == -1 || arr[point - 1] > val + 1)) {
				arr[point - 1] = val + 1;
				q.add(new Node(point - 1, val + 1));
			}
			
			// 앞으로 이동
			if (point + 1 <= 100000 && (arr[point + 1] == -1 || arr[point + 1] > val + 1)) {
				arr[point + 1] = val + 1;
				q.add(new Node(point + 1, val + 1));
			}
		}

		System.out.println(arr[K]);
	}
}