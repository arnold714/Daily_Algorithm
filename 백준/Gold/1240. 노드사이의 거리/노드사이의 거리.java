

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, target;
    static int[][] board;
    static ArrayList<Integer>[] list;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N + 1][N + 1];
    list = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
        list[i] = new ArrayList<Integer>();
    }
    for (int n = 0; n < N - 1; n++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        list[start].add(end);
        list[end].add(start);
        board[start][end] = dist;
        board[end][start] = dist;
    }
    StringBuilder sb = new StringBuilder();
    for (int m = 0; m < M; m++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        sb.append(tree(start, start)+"\n");
    }
    System.out.println(sb.toString());
}

private static int tree(int cur, int prv) {
    // TODO Auto-generated method stub
    if (cur == target) {
        return board[cur][prv];
    }
    int num = 0;
    for (int i = 0; i < list[cur].size(); i++) {
        int nxt = list[cur].get(i);
        if (nxt != prv) {
            num++;
        }
    }
    if (num == 0) {
        return -100000000;
    }

    int rtn = -100000000;
    for (int i = 0; i < list[cur].size(); i++) {
        int nxt = list[cur].get(i);
        if (nxt == prv) {
            continue;
        }
        int x = board[cur][prv] + tree(nxt, cur);
        rtn = rtn > x ? rtn : x;
    }
    return rtn;
}
}

