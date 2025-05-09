import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		long min = Long.MAX_VALUE;
		long[] answer = new long[3];
		for (int n = 0; n < N - 2; n++) {
			long now = list.get(n);
			for (int m = n + 1; m < N - 1; m++) {
				long sec = list.get(m);
				long secTarget = (long) (now + sec) * -1;
				int s = m + 1;
				int e = N - 1;
				int mid;
				long trd = 0;
				while (s <= e) {
					mid = (s + e) / 2;
					trd = list.get(mid);
					long sum = Math.abs((long)(now + sec + trd));
					if (min > sum) {
						min = sum;
						answer[0] = now;
						answer[1] = sec;
						answer[2] = trd;
					}
					if (trd <= secTarget) {
						s = mid + 1;
					} else {
						e = mid - 1;
					}
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}

}