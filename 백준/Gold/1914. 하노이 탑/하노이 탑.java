import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main{
    static StringBuilder sb = new StringBuilder("");
    static void hanoi(int n, int start, int end){
        if (n == 0)
            return;
        int mid = 6 - start - end;
        hanoi(n-1, start, mid);
        sb.append(start+ " "+ end + "\n");
        hanoi(n-1, mid, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger num = new BigInteger("2");
        sb.append(num.pow(N).subtract(new BigInteger("1")));
        if (N <= 20){
            sb.append("\n");
            hanoi(N,1,3);
        } 
        System.out.println(sb);
    }
}