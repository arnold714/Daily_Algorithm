import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Trie head;

	public static class Trie {
		String s;
		int depth;
		Map<String, Trie> children = new TreeMap<String, Trie>();

		Trie() {
			int depth = 0;
		}

		Trie(String s, int depth) {
			this.s = s;
			this.depth = depth;
		}
	}

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		head = new Trie();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] sArr = new String[K + 1];
			for (int k = 1; k <= K; k++) {
				sArr[k] = st.nextToken();
			}

			insert(sArr);
		}
		find(head);
		System.out.println(sb.toString());
	}

	private static void find(Trie trie) {
		if (trie.depth != 0) {
			for (int i = 0; i < 2 * (trie.depth - 1); i++) {
				sb.append("-");
			}
			sb.append(trie.s + "\n");
		}
		
		for (String key : trie.children.keySet()) {
			find(trie.children.get(key));
		}
	}

	private static void insert(String[] sArr) {
		// TODO Auto-generated method stub
		int size = sArr.length;
		Trie trie = head;
		for (int i = 1; i < size; i++) {
			if (!trie.children.containsKey(sArr[i])) {
				trie.children.put(sArr[i], new Trie(sArr[i], i));
			}
			trie = trie.children.get(sArr[i]);
		}
	}
}
