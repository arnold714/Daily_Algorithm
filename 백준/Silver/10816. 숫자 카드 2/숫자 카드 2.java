

import java.io.*;
import java.util.*;

public class Main{
	static int N, M, end, start;
	static int[] arr;
	static boolean flag = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int x = Integer.parseInt(st.nextToken());
			endTree(x);
			startTree(x);
			if(arr[start]!=x || arr[end]!=x) {
				sb.append(0+" ");
			}else {
				sb.append(end-start+1+" ");
			}
		}
		System.out.println(sb.toString());
	}

	private static void startTree(int x) {
		// TODO Auto-generated method stub
		int s = 0;
		int e = N - 1;
		int mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] < x) {
				s = mid + 1;
			} else {
				start = mid;
				e = mid - 1;
			}
		}
	}

	private static void endTree(int x) {
		// TODO Auto-generated method stub
		int s = 0;
		int e = N - 1;
		int mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] <= x) {
				end = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
	}

}
