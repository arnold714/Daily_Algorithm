
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
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
			if (N == 0 && M == 0) {
				break;
			}
			dp = new int[M + 1];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				// c: 칼로리 p:가격
				int c = Integer.parseInt(st.nextToken());
				int p = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
				for (int price = p; price <= M; price++) {
					dp[price] = Math.max(dp[price], dp[price - p] + c);
				}
			}
			System.out.println(dp[M]);
		}
	}

}