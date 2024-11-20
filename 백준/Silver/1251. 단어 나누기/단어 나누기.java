import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String left = "";
        String mid = "";
        String right = "";

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < input.length() - 1; i++) {
            left = input.substring(0, i);
            for (int j = i + 1; j < input.length(); j++) {
                String tmp = new String();
                mid = input.substring(i, j);
                right = input.substring(j);
                tmp += backward(left);
                tmp += backward(mid);
                tmp += backward(right);
                list.add(tmp);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
    static String backward(String word) {
        String tmp = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            tmp += word.charAt(i);
        }
        return tmp;
    }
}