import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[M];
		recur(1, 0);
		System.out.println(sb.toString());
	}

	private static void recur(int cur, int cnt) {

		if (cnt == M) {
			for (int m = 0; m < M; m++) {
				sb.append(arr[m] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = cur; i <= N; i++) {
			arr[cnt] = i;
			recur(i, cnt + 1);
		}
	}

}