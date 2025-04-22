import java.io.*;

public class Main {
    static String S, T;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(result);
    }

    public static void dfs(String current) {
        if (current.length() == S.length()) {
            if (current.equals(S)) {
                result = 1;
            }
            return;
        }

        if (current.endsWith("A")) {
            dfs(current.substring(0, current.length() - 1));
        }

        if (current.startsWith("B")) {
            StringBuilder sb = new StringBuilder(current.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
