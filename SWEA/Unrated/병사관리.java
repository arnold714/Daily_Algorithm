class UserSolution {
	public class Node {
		int id;
		int v;
		Node nxt;

		Node() {
		}

		Node(int id, int v) {
			this.id = id;
			this.v = v;
			this.nxt = null;
		}

		Node(int id, int v, Node nxt) {
			this.id = id;
			this.v = v;
			this.nxt = nxt;
		}
	}

	public Node[] node;
	public int cnt;
	public int[] version;
	public int[] num;

	public Node getNewNode(int id, Node nxt) {
		Node ret = node[cnt++];
		ret.id = id;
		ret.v = ++version[id];
		ret.nxt = nxt;
		return ret;
	}

	public class Team {
		Node[] head = new Node[6];
		Node[] tail = new Node[6];
	}

	public Team[] t;

	public void init() {
		cnt = 0;
		node = new Node[200055];
		for (int i = 0; i < 200055; i++) {
			node[i] = new Node();
		}
		version = new int[100055];
		num = new int[100055];
		t = new Team[6];
		for (int i = 1; i <= 5; i++) {
			t[i] = new Team();
			for (int j = 1; j <= 5; j++) {
				t[i].head[j] = t[i].tail[j] = getNewNode(0, null);
			}
		}
	}

	public void hire(int mID, int mTeam, int mScore) {
		Node newNode = getNewNode(mID, null);
		t[mTeam].tail[mScore].nxt = newNode;
		t[mTeam].tail[mScore] = newNode;
		num[mID] = mTeam;
	}

	public void fire(int mID) {
		version[mID] = -1;
	}

	public void updateSoldier(int mID, int mScore) {
		hire(mID, num[mID], mScore);
	}

	public void updateTeam(int mTeam, int mChangeScore) {
		if (mChangeScore < 0) {
			for (int i = 1; i <= 5; i++) {
				int k = i + mChangeScore;
				k = k < 1 ? 1 : (k > 5 ? 5 : k);
				if (i == k)
					continue;

				if (t[mTeam].head[i].nxt == null)
					continue;
				t[mTeam].tail[k].nxt = t[mTeam].head[i].nxt;
				t[mTeam].tail[k] = t[mTeam].tail[i];
				t[mTeam].head[i].nxt = null;
				t[mTeam].tail[i] = t[mTeam].head[i];

			}

		} else if (mChangeScore > 0) {
			for (int j = 5; j >= 1; j--) {
				int k = j + mChangeScore;
				k = k < 1 ? 1 : (k > 5 ? 5 : k);
				if (j == k)
					continue;

				if (t[mTeam].head[j].nxt == null)
					continue;
				t[mTeam].tail[k].nxt = t[mTeam].head[j].nxt;
				t[mTeam].tail[k] = t[mTeam].tail[j];
				t[mTeam].head[j].nxt = null;
				t[mTeam].tail[j] = t[mTeam].head[j];
			}
		}

	}

	public int bestSoldier(int mTeam) {
		for (int j = 5; j >= 1; j--) {
			Node node = t[mTeam].head[j].nxt;
			if (node == null)
				continue;

			int ans = 0;
			while (node != null) {
				if (node.v == version[node.id]) {
					ans = ans < node.id ? node.id : ans;
				}
				node = node.nxt;
			}
			if (ans != 0)
				return ans;
		}
		return 0;
	}
}
