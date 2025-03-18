import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<int[]>[] list;
	static int[] dist;

	public static class Node implements Comparable<Node>{
		int cur;
		int cost;
		ArrayList<Integer> answer;
		
		Node(int cur, int cost, ArrayList<Integer> answer){
			this.cur = cur;
			this.cost = cost;
			this.answer = (ArrayList<Integer>) answer.clone();
			this.answer.add(cur);
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			list[n] = new ArrayList<int[]>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[S].add(new int[] { E, C });
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(s);
		
		for (int i = 0; i < list[s].size(); i++) {
			int[] nxt = list[s].get(i);
			pq.add(new Node(nxt[0], nxt[1], answer));
		}
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.cur == e) {
				if(s == e) {
					sb.append(0+"\n");
					sb.append(1+"\n");
					sb.append(s);
					break;
				}
				dist[node.cur] = node.cost;
				sb.append(dist[e]+"\n");
				sb.append(node.answer.size()+"\n");
				for(int i = 0 ; i < node.answer.size(); i++) {
					sb.append(node.answer.get(i)+" ");
				}
				break;
			}
			
			if(dist[node.cur] <= node.cost) {
				continue;
			}
			dist[node.cur] = node.cost;
			
			for(int i = 0 ; i < list[node.cur].size(); i++) {
				int[] nxt = list[node.cur].get(i);
				pq.add(new Node(nxt[0], node.cost+ nxt[1], node.answer));
			}
		}
		
		System.out.println(sb.toString());
	}
}
