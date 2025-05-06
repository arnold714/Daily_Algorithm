import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		String Y = br.readLine();
		int xlen = X.length();
		int ylen = Y.length();
		dp = new int[xlen][ylen];
		for (int i = 0; i < xlen; i++) {
			Arrays.fill(dp[i], -1);
		}
		int answer = lcs(X, Y, xlen - 1, ylen - 1);
		System.out.println(answer);
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