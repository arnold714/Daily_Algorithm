

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int x = Integer.parseInt(st.nextToken());
			if(bnTree(x)) {
				sb.append(1+" ");
			}else {
				sb.append(0+" ");
			}
		}
		System.out.println(sb.toString());
	}

	public static boolean bnTree(int x) {
		int s = 0;
		int e = N - 1;
		int mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if(arr[mid]<x) {
				s = mid +1;
			}else {
				answer = mid;
				e = mid -1;
			}
		}
		if(arr[answer]==x) {
			return true;
		}else {
			return false;
		}
	}
}