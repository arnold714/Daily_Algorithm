

import java.util.*;
import java.io.*;

public class Main {
	static char[] P;
	static String X;
	static int N, dir;
	static Deque<Integer> deq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			P = st.nextToken().toCharArray();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			X = st.nextToken();
			X = X.substring(1);
			X = X.replace(']', ',');
			String[] strarr = X.split(",");
			
			
			deq = new ArrayDeque<>();
			for(int i = 0 ; i < strarr.length; i++) {
				deq.add(Integer.parseInt(strarr[i]));
			}
			
			dir = 1;
			ArrayList<Integer> answer = command();
			sb = new StringBuilder();
			if(answer.isEmpty()) {
				sb.append("[]\n");
			}
			else if(answer.get(0)==-1) {
				sb = new StringBuilder();
				sb.append("error\n");
			}else {
				for(int i = 0 ; i < answer.size(); i++) {
					if(i==0 && answer.size()==1) {
						sb.append("["+answer.get(i)+"]\n");
					}else if(i==0){
						sb.append("["+answer.get(i)+",");
					}else if(i == answer.size()-1) {
						sb.append(answer.get(i)+"]\n");
					}else {
						sb.append(answer.get(i)+",");
					}
				}
			}
			sb2.append(sb.toString());
		}
		System.out.println(sb2.toString());
	}

	private static ArrayList<Integer> command() {
		// TODO Auto-generated method stub
		int len = P.length;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			char com = P[i];
			if (com == 'R') {
				dir *= -1;
			} else {
				if (dir == 1) {
					if (deq.isEmpty()) {
						list = new ArrayList<>();
						list.add(-1);
						return list;
					} else {
						deq.pollFirst();
					}
				} else if (dir == -1) {
					if (deq.isEmpty()) {
						list = new ArrayList<>();
						list.add(-1);
						return list;
					} else {
						deq.pollLast();
					}
				}
			}
		}
		len = deq.size();

		for (int i = 0; i < len; i++) {
			if (dir == 1) {
				list.add(deq.pollFirst());
			} else if (dir == -1) {
				list.add(deq.pollLast());
			}
		}
		return list;
	}

}
