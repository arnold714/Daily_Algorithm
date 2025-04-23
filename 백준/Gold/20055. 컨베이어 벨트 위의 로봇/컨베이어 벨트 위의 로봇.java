import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int N2 = N * 2;
		st = new StringTokenizer(br.readLine());
		int[] belt = new int[N2];
		for (int n = 0; n < N2; n++) {
			belt[n] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[N2];
		int start = 0;
		int zeroCnt = 0;
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();

		while (zeroCnt < K) {
			answer++;
			// 1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			start = (start + N2 - 1) % N2;
			if (visited[(start + N - 1) % N2]) {
				visited[(start + N - 1) % N2] = false;
				q.poll();
			}
			// 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
			// 만약 이동할 수 없다면 가만히 있는다.
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				int now = q.poll();
				int nxt = (now + 1) % N2;
				if (belt[nxt] > 0 && !visited[nxt]) {
					if (nxt != (start + N - 1) % N2) {
						visited[nxt] = true;
						q.offer(nxt);
					}
					visited[now] = false;
					belt[nxt]--;
					if (belt[nxt] == 0) {
						zeroCnt++;
					}

				} else {
					q.offer(now);
				}
			}
			// 3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (belt[start] > 0) {
				belt[start]--;
				q.offer(start);
				visited[start] = true;
				if (belt[start] == 0) {
					zeroCnt++;
				}
			}
			// 4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.

			if (!q.isEmpty() && q.peek() == (start + N - 1) % N2) {
				q.poll();
				visited[(start + N - 1) % N2] = false;
			}
		}
		System.out.println(answer);
	}
}