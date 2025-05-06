import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	static StringBuilder sb;
	static String X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		X = br.readLine();
		Y = br.readLine();
		int xlen = X.length();
		int ylen = Y.length();
		dp = new int[xlen][ylen];
		for (int i = 0; i < xlen; i++) {
			Arrays.fill(dp[i], -1);
		}
		int answer = lcs(X, Y, xlen - 1, ylen - 1);
		int xnow = xlen - 1;
		int ynow = ylen - 1;
		for (int i = answer; i > 0; i--) {
			while (ynow > 0 && dp[xnow][ynow - 1] == i) {
				ynow--;
			}
			while (xnow > 0 && dp[xnow - 1][ynow] == i) {
				xnow--;
			}
			sb.append(X.charAt(xnow));
			xnow -= 1;
			ynow -= 1;
		}
		System.out.println(answer);
		if (answer != 0) {
			System.out.println(sb.reverse().toString());
		}
	}

	private static Integer lcs(String X, String Y, int xlen, int ylen) {
		// TODO Auto-generated method stub
		if (xlen < 0 || ylen < 0) {
			return 0;
		}
		if (dp[xlen][ylen] == -1) {
			if (X.charAt(xlen) == Y.charAt(ylen)) {
				dp[xlen][ylen] = lcs(X, Y, xlen - 1, ylen - 1) + 1;
			} else {
				dp[xlen][ylen] = Math.max(lcs(X, Y, xlen - 1, ylen), lcs(X, Y, xlen, ylen - 1));
			}
		}
		return dp[xlen][ylen];
	}
}