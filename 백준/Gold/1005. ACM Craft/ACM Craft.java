import java.io.*;
import java.util.*;

public class Main {
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] time = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				time[n] = Integer.parseInt(st.nextToken());
			}
			int[] enter = new int[N + 1];
			answer = new int[N + 1];
			ArrayList<Integer>[] list = new ArrayList[N + 1];
			for (int n = 1; n <= N; n++) {
				list[n] = new ArrayList<Integer>();
			}
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				list[S].add(E);
				enter[E]++;
			}
			topologySort(time, list, enter, N);
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			sb.append(answer[W] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void topologySort(int[] time, ArrayList<Integer>[] list, int[] enter, int N) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		for (int n = 1; n <= N; n++) {
			if (enter[n] == 0) {
				q.add(n);
				answer[n] = time[n];
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < list[now].size(); i++) {
				int nxt = list[now].get(i);
				answer[nxt] = Math.max(answer[nxt], answer[now] + time[nxt]);
				enter[nxt]--;
				if (enter[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
	}

}