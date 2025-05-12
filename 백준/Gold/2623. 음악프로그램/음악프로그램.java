import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] enter;
	static ArrayList<Integer>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		enter = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int n = 1; n <= N; n++) {
			list[n] = new ArrayList<Integer>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int now = Integer.parseInt(st.nextToken());
			for (int k = 1; k < K; k++) {
				int nxt = Integer.parseInt(st.nextToken());
				list[now].add(nxt);
				enter[nxt]++;
				now = nxt;
			}
		}
		topologySort();
		boolean flag = true;
		for (int n = 1; n <= N; n++) {
			if (enter[n] != 0) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println(sb.toString());
		}else {
			System.out.println(0);
		}
	}

	private static void topologySort() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		for (int n = 1; n <= N; n++) {
			if (enter[n] == 0) {
				q.add(n);
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + "\n");
			for (int i = 0; i < list[now].size(); i++) {
				int nxt = list[now].get(i);
				enter[nxt]--;
				if (enter[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
	}

}