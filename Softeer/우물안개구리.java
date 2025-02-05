import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] W = new int[N+1];
        for(int n = 1 ; n <= N ; n++){
            W[n] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, -1);
        for(int m = 0 ; m < M ; m++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(arr[A] < W[B]){
                arr[A] = W[B];
            }
            if(arr[B] < W[A]){
                arr[B] = W[A];
            }
        }
        int answer = N ;
        for(int n = 1 ; n <= N ; n++){
            if(arr[n] >= W[n]){
                answer--;
            }
        }
        System.out.println(answer);
    }
}
