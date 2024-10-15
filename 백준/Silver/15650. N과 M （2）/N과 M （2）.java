

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
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		recur(1, 0);
	}

	private static void recur(int cur, int cnt) {
		// TODO Auto-generated method stub
		if (cnt == M) {
			for(int m = 0; m < M ; m++) {
				System.out.print(list.get(m)+" ");
			}
			System.out.println();
			return;
		}
		if (cur > N)
			return;
		list.add(cur);
		recur(cur + 1, cnt + 1);
		list.remove(list.size() - 1);
		recur(cur + 1, cnt);
	}

}