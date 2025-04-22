import java.io.*;
import java.util.*;

public class Main {
    static int targetSize, answer;
    static String T, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        targetSize = S.length();
        T = br.readLine();

        Deque<Character> dq = new LinkedList<>();
        for (char c : T.toCharArray()) {
            dq.addLast(c);
        }

        dfs(dq, true);
        System.out.println(answer);
    }

    public static void dfs(Deque<Character> dq, boolean isStraight) {
        if (dq.size() == targetSize) {
            StringBuilder sb = new StringBuilder();
            if (isStraight) {
                for (char c : dq) sb.append(c);
            } else {
                Iterator<Character> it = dq.descendingIterator();
                while (it.hasNext()) sb.append(it.next());
            }

            if (sb.toString().equals(S)) {
                answer = 1;
            }
            return;
        }

        if (isStraight) {
            // 뒤에 A 제거 가능
            if (dq.peekLast() != null && dq.peekLast() == 'A') {
                dq.pollLast();
                dfs(dq, isStraight);
                dq.offerLast('A');
            }

            // 앞에 B 제거 + 방향 뒤집기
            if (dq.peekFirst() != null && dq.peekFirst() == 'B') {
                dq.pollFirst();
                dfs(dq, !isStraight);
                dq.offerFirst('B');
            }

        } else {
            // 역방향일 경우 처리 반대
            // 앞에 A 제거 가능
            if (dq.peekFirst() != null && dq.peekFirst() == 'A') {
                dq.pollFirst();
                dfs(dq, isStraight);
                dq.offerFirst('A');
            }

            // 뒤에 B 제거 + 방향 전환
            if (dq.peekLast() != null && dq.peekLast() == 'B') {
                dq.pollLast();
                dfs(dq, !isStraight);
                dq.offerLast('B');
            }
        }
    }
}
