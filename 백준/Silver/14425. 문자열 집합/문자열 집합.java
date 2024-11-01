
import java.io.*;
import java.util.*;

public class Main{
	static int N, M, answer;
	static char OFFSET = 'a';

	public static class Trie {
		boolean isWordEnd; // 이 정점에서 끝나는 문자열이 존재하는지 표
		int[] children;
		// 이 정점을 root로 하는 subtree 포함된 문자열 개수

		Trie() {
			children = new int[26];
			Arrays.fill(children, -1);
			isWordEnd = false;
		}
	}

	static List<Trie> nodes;

	public static void insert(String str) {
		int nodeNum = 0;
		for(char alphabet : str.toCharArray()) {
			int index = alphabet - OFFSET;
			if(nodes.get(nodeNum).children[index]==-1) {
				nodes.get(nodeNum).children[index] = nodes.size();
				nodes.add(new Trie());
			}
			nodeNum = nodes.get(nodeNum).children[index];
		}
		nodes.get(nodeNum).isWordEnd = true;
	}
	public static boolean find(String str) {
		int nodeNum = 0;
		for(char alphabet : str.toCharArray()) {
			int index = alphabet - OFFSET;
			if(nodes.get(nodeNum).children[index]==-1) {
				return false;
			}
			nodeNum = nodes.get(nodeNum).children[index];
		}
		return nodes.get(nodeNum).isWordEnd;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new ArrayList<>();
		nodes.add(new Trie());
		for (int n = 0; n < N; n++) {
			insert(br.readLine());
		}
		for (int m = 0; m < M; m++) {
			if(find(br.readLine())){
				answer++;
			}
		}
		System.out.println(answer);
	}
}
