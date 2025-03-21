
import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		K = Integer.parseInt(st.nextToken());

		recur(K);
		System.out.println(sb.toString());
	}

	public static void recur(int K) {
		if (K == 1) {
			sb.append(4);
			return;
		} else if (K == 2) {
			sb.append(7);
			return;
		} else if (K % 2 == 1) {
			recur((K-1)/2);
			sb.append(4);
		} else {
			recur((K-2)/2);
			sb.append(7);
		}
	}
}
