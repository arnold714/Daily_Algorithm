
import java.io.*;
import java.util.*;

public class Main {
	static boolean answer;
	
	public static class Trie {
		char alphabet;
		boolean isTerminal;
		Map<Character, Trie> children = new HashMap<Character, Trie>();

		Trie() {

		}

		Trie(char alphabet) {
			this.alphabet = alphabet;
			this.isTerminal = false;
		}
	}
	
	public static Trie head;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			head = new Trie();
			answer = true;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				if(answer) {
					insert(str);
				}
			}
			if(answer) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");

			}
		}
		System.out.println(sb.toString());
	}

	private static void insert(String str) {
		// TODO Auto-generated method stub
		Trie indexTrie = head;
		boolean flag = false;
		for(char c : str.toCharArray()) {
			if(!indexTrie.children.containsKey(c)) {
				if(indexTrie.isTerminal) {
					break;
				}
				Trie newTrie = new Trie(c);
				indexTrie.children.put(c, newTrie);
				flag = true;
			}
			indexTrie = indexTrie.children.get(c);
		}
		indexTrie.isTerminal = true;
		if(!flag) {
			answer = false;
		}
	}
}
