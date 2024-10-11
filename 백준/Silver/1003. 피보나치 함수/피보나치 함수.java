
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] dp = new int[41][2];
		dp[0] = new int[] { 1, 0 };
		dp[1] = new int[] { 0, 1 };
		for(int i = 2 ; i < 41; i++) {
			int x = dp[i-1][0] + dp[i-2][0];
			int y = dp[i-1][1] + dp[i-2][1];
			dp[i] = new int[] {x, y};
		}
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			System.out.println(dp[N][0]+" "+ dp[N][1]);
		}
	}
}