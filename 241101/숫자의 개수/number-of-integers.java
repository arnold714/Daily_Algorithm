import java.util.*;
import java.io.*;
public class Main {
    static long[] arr;
    static int N, M;
    static int a, b;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int n = 0 ; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int m = 0 ; m < M ; m++){
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            a = N-1;
            b = 0;
            bnTree1(x);
            bnTree2(x);
            if(arr[a]==x || arr[b]==x){
                sb.append(a-b+"\n");
            }else{
                if(a-b-1<0){
                    sb.append(0+"\n");
                }else{
                    sb.append(a-b-1+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
    public static void bnTree1(long target){
        int s = 0;
        int e = N -1;
        int mid = 0;
        while(s <= e){
            mid = (s+e)/2;
            if(arr[mid] <= target){
                s = mid + 1;
            }else{
                a = mid;
                e = mid -1;
            }
        }
    }
    public static void bnTree2(long target){
        int s = 0;
        int e = N -1;
        int mid = 0;
        while(s <= e){
            mid = (s+e)/2;
            if(arr[mid] < target){
                b = mid;
                s = mid + 1;
            }else{
                e = mid -1;
            }
        }
    }
}