import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] alpha = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				alpha[i] = new ArrayList<Integer>();
			}
			int cnt = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean hasanswer = false;
			for (char c : W.toCharArray()) {
				alpha[c - 'a'].add(cnt++);
			}
			int[] cntArr = new int[26];
			for (int i = 0; i < 26; i++) {
				cntArr[i] = alpha[i].size();
				if (cntArr[i] >= K) {
					hasanswer = true;
					for (int j = 0; j < cntArr[i] - K + 1; j++) {
						int now = alpha[i].get(j + K - 1) - alpha[i].get(j) + 1;
						min = now < min ? now : min;
						max = now > max ? now : max;
					}
				}
			}
			if (hasanswer) {
				sb.append(min + " " + max + "\n");
			} else {
				sb.append(-1 + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}