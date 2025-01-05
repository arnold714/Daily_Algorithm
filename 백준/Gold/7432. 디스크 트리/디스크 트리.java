
import java.util.*;
import java.io.*;

public class Main{
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		TrieNode trieNode = new TrieNode();
		for (int n = 0; n < N; n++) {
			String strs = br.readLine();
			trieNode.insert(strs);
		}
		trieNode.print(trieNode, 0);
	}

	static class TrieNode {
		Map<String, TrieNode> childNode = new HashMap<>();

		TrieNode() {

		}

		public void insert(String strs) {
			// TODO Auto-generated method stub
			TrieNode trieNode = this;
			String[] str = strs.split("\\\\");
			for (String s : str) {
				trieNode.childNode.putIfAbsent(s, new TrieNode());
				trieNode = trieNode.childNode.get(s);
			}
		}

		public void print(TrieNode cur, int depth) {
			// TODO Auto-generated method stub
			TrieNode trieNode = cur;
			if (trieNode.childNode != null) {
				List<String> list = new ArrayList<String>(trieNode.childNode.keySet());
				Collections.sort(list);
				for (String str : list) {
					for (int i = 0; i < depth; i++) {
						System.out.print(" ");
					}
					System.out.println(str);
					print(trieNode.childNode.get(str), depth + 1);
				}
			}
		}
	}
}