
import java.io.*;
import java.util.*;

public class Main {
	static int s, e, mid, N, C, answer;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		list = new ArrayList<Integer>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		s = 1;
		e = list.get(N - 1) - list.get(0);

		while (s <= e) {
			mid = (s + e) / 2;
			boolean isPossible = bnSearch(mid);
			if (isPossible) {
				answer = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(answer);
	}

	private static boolean bnSearch(int mid) {
		// TODO Auto-generated method stub
		int cnt = 1;
		int prv = list.get(0);
		int now;
		for (int n = 1; n < N; n++) {
			now = list.get(n);
			if (now - prv >= mid) {
				cnt++;
				prv = now;
			}

			if (cnt >= C) {
				return true;
			}
		}

		return false;
	}

}
