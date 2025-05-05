import java.io.*;
import java.util.*;

public class Main {
	static int N, S, answer, max;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		int s = 1;
		int e = N;
		int mid;
		while (s <= e) {
			mid = (s + e) / 2;
			check(mid);
			if (max < S) {
				s = mid + 1;
			} else {
				answer = mid;
				e = mid - 1;
			}
		}
		System.out.println(answer);
	}

	private static void check(int mid) {
		// TODO Auto-generated method stub
		max = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int now = 0;
		for (int n = 0; n < N; n++) {
			if (q.size() == mid) {
				now -= q.poll();
			}
			q.offer(arr[n]);
			now += arr[n];
			max = max > now ? max : now;
		}
	}
}