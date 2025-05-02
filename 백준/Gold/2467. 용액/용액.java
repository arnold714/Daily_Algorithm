import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] flask = new long[N];
		for (int n = 0; n < N; n++) {
			flask[n] = Long.parseLong(st.nextToken());
		}
		long[] answerArr = new long[2];
		long min = Long.MAX_VALUE;
		for (int n = 0; n < N; n++) {
			Long now = flask[n];
			Long target = now * -1;
			Long answer = 0L;
			int s = n + 1;
			int e = N - 1;
			int mid;
			while (s <= e) {
				mid = (s + e) / 2;
				long sum = Math.abs(flask[n] + flask[mid]);
				if (min > sum) {
					min = sum;
					answerArr[0] = flask[n];
					answerArr[1] = flask[mid];
				}
				if (flask[mid] >= -flask[n]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}

			}
		}
		System.out.println(answerArr[0] + " " + answerArr[1]);
	}
}