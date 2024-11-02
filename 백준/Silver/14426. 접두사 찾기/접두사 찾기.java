
import java.util.*;
import java.io.*;

public class Main{
	static class Trie {
		char alphabet;
		Map<Character, Trie> children = new HashMap<Character, Trie>();

		Trie(char alphabet) {
			this.alphabet = alphabet;
		}

		Trie() {
		}
	}

	static int answer = 0;
	static Trie head = new Trie();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			insert(str);
		}
		for (int m = 0; m < M; m++) {
			String str = br.readLine();
			if (find(str)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void insert(String str) {
		// TODO Auto-generated method stub
		Trie indexTrie = head;
		for (char c : str.toCharArray()) {
			if (!indexTrie.children.containsKey(c)) {
				Trie newTrie = new Trie(c);
				indexTrie.children.put(c, newTrie);
			}
			indexTrie = indexTrie.children.get(c);
		}
	}
	
	private static boolean find(String str) {
		// TODO Auto-generated method stub
		Trie indexTrie = head;
		for (char c : str.toCharArray()) {
			if (!indexTrie.children.containsKey(c)) {
				return false;
			}
			indexTrie = indexTrie.children.get(c);
		}
		return true;
	}

	

}