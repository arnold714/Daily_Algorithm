import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class UserSolution {
	public int[][] nMap;
	public int size, M;
	public int[] xdir = new int[] { 0, 1, 0, -1 };
	public int[] ydir = new int[] { 1, 0, -1, 0 };

	public void init(int N, int mMap[][]) {
		size = N;
		nMap = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				nMap[i][j] = mMap[i][j];
			}
		}
	}

	public int numberOfCandidate(int M, int mStructure[]) {
		int cnt = 0;
		if (M == 1) {
			return size * size;
		}
		int[] nStructure = new int[M];
		for (int m = 0; m < M; m++) {
			nStructure[m] = mStructure[M - m - 1];
		}
		int target1 = 0, target2 = 0;
		boolean ok1 = true, ok2 = true;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= size - M; j++) {

				target1 = nMap[i][j] + mStructure[0];
				target2 = nMap[i][j] + nStructure[0];
				ok1 = true;
				ok2 = true;
				for (int m = 1; m < M; m++) {

					if (nMap[i][j + m] + mStructure[m] != target1) {
						ok1 = false;
					}

					if (nMap[i][j + m] + nStructure[m] != target2) {
						ok2 = false;
					}

					if (!ok1 && !ok2) {
						break;
					}
					if (m == M - 1 && (ok1 || ok2)) {
						cnt++;
					}
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= size - M; j++) {

				target1 = nMap[j][i] + mStructure[0];
				target2 = nMap[j][i] + nStructure[0];
				ok1 = true;
				ok2 = true;
				for (int m = 0; m < M; m++) {

					if (nMap[j + m][i] + mStructure[m] != target1) {
						ok1 = false;
					}

					if (nMap[j + m][i] + nStructure[m] != target2) {
						ok2 = false;
					}

					if (!ok1 && !ok2) {
						break;
					}
					if (m == M - 1 && (ok1 || ok2)) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public int maxArea(int M, int mStructure[], int mSeaLevel) {
		int max = -1;
		if (M == 1) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					nMap[i][j] += mStructure[0];
					if (max == -1) {
						max = bfs(mSeaLevel);
					} else {
						max = max > bfs(mSeaLevel) ? max : bfs(mSeaLevel);
					}
					nMap[i][j] -= mStructure[0];
				}
			}
			return max;
		}

		int[] nStructure = new int[M];
		for (int m = 0; m < M; m++) {
			nStructure[m] = mStructure[M - m - 1];
		}
		int target1 = 0, target2 = 0;
		boolean ok1 = true, ok2 = true;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= size - M; j++) {

				target1 = nMap[i][j] + mStructure[0];
				target2 = nMap[i][j] + nStructure[0];
				ok1 = true;
				ok2 = true;
				for (int m = 1; m < M; m++) {

					if (nMap[i][j + m] + mStructure[m] != target1) {
						ok1 = false;
					}

					if (nMap[i][j + m] + nStructure[m] != target2) {
						ok2 = false;
					}

					if (!ok1 && !ok2) {
						break;
					}
					if (m == M - 1) {
						if (!ok2) {
							for (int x = 0; x < M; x++) {
								nMap[i][j + x] += mStructure[x];
							}
							if (max == -1) {
								max = bfs(mSeaLevel);
							} else {
								max = max > bfs(mSeaLevel) ? max : bfs(mSeaLevel);
							}
							for (int x = 0; x < M; x++) {
								nMap[i][j + x] -= mStructure[x];
							}
						} else {
							for (int x = 0; x < M; x++) {
								nMap[i][j + x] += nStructure[x];
							}
							if (max == -1) {
								max = bfs(mSeaLevel);
							} else {
								max = max > bfs(mSeaLevel) ? max : bfs(mSeaLevel);
							}
							for (int x = 0; x < M; x++) {
								nMap[i][j + x] -= nStructure[x];
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= size - M; j++) {

				target1 = nMap[j][i] + mStructure[0];
				target2 = nMap[j][i] + nStructure[0];
				ok1 = true;
				ok2 = true;
				for (int m = 0; m < M; m++) {

					if (nMap[j + m][i] + mStructure[m] != target1) {
						ok1 = false;
					}

					if (nMap[j + m][i] + nStructure[m] != target2) {
						ok2 = false;
					}

					if (!ok1 && !ok2) {
						break;
					}
					if (m == M - 1) {
						if (!ok2) {
							for (int x = 0; x < M; x++) {
								nMap[j + x][i] += mStructure[x];
							}
							if (max == -1) {
								max = bfs(mSeaLevel);
							} else {
								max = max > bfs(mSeaLevel) ? max : bfs(mSeaLevel);
							}
							for (int x = 0; x < M; x++) {
								nMap[j + x][i] -= mStructure[x];
							}
						} else {
							for (int x = 0; x < M; x++) {
								nMap[j + x][i] += nStructure[x];
							}
							if (max == -1) {
								max = bfs(mSeaLevel);
							} else {
								max = max > bfs(mSeaLevel) ? max : bfs(mSeaLevel);
							}
							for (int x = 0; x < M; x++) {
								nMap[j + x][i] -= nStructure[x];
							}
						}
					}
				}
			}
		}
		return max;
	}

	private int bfs(int mSeaLevel) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[size][size];
		int cnt = size * size;
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < size; i++) {
			// row 가 0
			if (nMap[0][i] < mSeaLevel) {
				q.add(new int[] { 0, i });
			}

			// row 가 size -1
			if (nMap[size - 1][i] < mSeaLevel) {
				q.add(new int[] { size - 1, i });
			}

			// col 가 0
			if (nMap[i][0] < mSeaLevel) {
				q.add(new int[] { i, 0 });
			}

			// col 가 size -1
			if (nMap[i][size - 1] < mSeaLevel) {
				q.add(new int[] { i, size - 1 });
			}
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (visited[now[0]][now[1]]) {
				continue;
			}
			visited[now[0]][now[1]] = true;
			cnt--;

			for (int i = 0; i < 4; i++) {
				int xnext = now[0] + xdir[i];
				int ynext = now[1] + ydir[i];
				if (xnext >= 0 && xnext < size && ynext >= 0 && ynext < size && !visited[xnext][ynext]
						&& nMap[xnext][ynext] < mSeaLevel) {
					q.add(new int[] { xnext, ynext });
				}
			}
		}

		return cnt;
	}
}
