
import java.io.*;
import java.util.*;

public class Main{
    static int N, M, K;
    static int SIZE = 1 << 21;
    static int len = 1 << 20;
    static long[] arr, tree;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new long[N];
    tree = new long[SIZE];
    for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        arr[n] = Long.parseLong(st.nextToken());
    }
    makeTree();
    for (int i = 0; i < M + K; i++) {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        if (A == 1) {
            update(B, C);
        } else if (A == 2) {
            sb.append(get(1, 0, len - 1, B - 1, (int)C - 1) + "\n");
        }
    }
    System.out.println(sb.toString());
}

private static long get(int idx, int s, int e, int ts, int te) {
    // TODO Auto-generated method stub
    if (e < ts || s > te)
        return 0;
    else if (e <= te && s >= ts)
        return tree[idx];

    int mid = (s + e) / 2;
    long l = get(2 * idx, s, mid, ts, te);
    long r = get(2 * idx + 1, mid + 1, e, ts, te);
    return l + r;
}

private static void update(int B, long C) {
    // TODO Auto-generated method stub
    int idx = len + B - 1;
    tree[idx] = C;
    while (idx != 1) {
        idx /= 2;
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }
}

private static void makeTree() {
    // TODO Auto-generated method stub
    for (int i = 0; i < N; i++) {
        tree[len + i] = arr[i];
    }

    for (int i = len - 1; i >= 1; i--) {
        tree[i] = tree[2 * i] + tree[2 * i + 1];
    }
}
}