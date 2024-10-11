
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N, X, answer;
	static int[][] board1;
	static int[][] board2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub\
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			board1 = new int[N][N];
			board2 = new int[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board1[i][j] = Integer.parseInt(st.nextToken());
					board2[j][i] = board1[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				check(i, board1);
				check(i, board2);
			}
		System.out.println(answer);

	}

	private static void check(int i, int[][] board) {
		// TODO Auto-generated method stub
		int sameHeight = 1;
		int before = board[i][0];
		for (int j = 1; j < N; j++) {
			int now = board[i][j];
			if (before == now) {
				sameHeight++;
				continue;
			} else if (Math.abs(before - now) > 1) {
				return;
			} else if (before > now) {
				for (int x = 1; x < X; x++) {
					if (j + x >= N || now != board[i][j + x]) {
						return;
					}
				}
				sameHeight = 0;
				before = now;
				j += X - 1;

			} else if (now > before) {
				if (sameHeight >= X) {
					sameHeight = 1;
					before = now;
				}else {
					return;
				}
			}
		}
		answer++;
	}
}
