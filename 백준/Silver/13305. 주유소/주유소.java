import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] dist = new int[N - 1];
		for (int n = 0; n < N - 1; n++) {
			dist[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long[] oil = new long[N];
		for (int n = 0; n < N; n++) {
			oil[n] = Long.parseLong(st.nextToken());
		}
		long min_cost = Long.MAX_VALUE;
		long answer = 0;
		for (int n = 0; n < N - 1; n++) {
			if (oil[n] < min_cost) {
				min_cost = oil[n];
			}
			answer += dist[n] * min_cost;
		}
		System.out.println(answer);
	}
}