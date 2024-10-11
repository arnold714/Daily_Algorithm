
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[][] point = new int[N + 1][2];
		for (int n = 1; n <= N; n++) {
			stair[n] = Integer.parseInt(br.readLine());
		}
		point[1][0] = stair[1];
		for (int n = 0; n < N; n++) {
			if (n + 2 <= N) {
				point[n + 2][0] = point[n + 2][0] > point[n][0] + stair[n + 2] ? point[n + 2][0]
						: point[n][0] + stair[n + 2];
				point[n + 2][0] = point[n + 2][0] > point[n][1] + stair[n + 2] ? point[n + 2][0]
						: point[n][1] + stair[n + 2];
			}
			if (n + 1 <= N) {
				point[n + 1][1] = point[n + 1][1] > point[n][0] + stair[n + 1] ? point[n + 1][1]
						: point[n][0] + stair[n + 1];
			}
		}
		int answer = 0;
		System.out.println(answer = point[N][0] > point[N][1] ? point[N][0] : point[N][1]);
	}
}