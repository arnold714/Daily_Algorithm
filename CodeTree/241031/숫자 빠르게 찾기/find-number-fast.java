import java.util.*;
import java.io.*;

public class Main {
    static int N, M, target;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0 ; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb= new StringBuilder();

        for(int m = 0 ; m< M; m++){
            answer = -1;
            target = Integer.parseInt(br.readLine());
            bnTree();
            if(answer != -1 && target==arr[answer]){
                sb.append(answer+1+"\n");
            }else{
                sb.append(-1+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void bnTree(){
        int s = 0; 
        int e = N-1;
        int mid = 0;
        while(s <= e){
            mid = (s + e)/2;
            if(arr[mid] < target){
                s = mid +1;
            }else{
                answer = mid;
                e = mid -1;
            }
        }
    }
}
