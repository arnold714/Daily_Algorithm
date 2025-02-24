import java.util.*;
import java.io.*;

public class Main {
    static int[][] segments;
    static int n = 0 ;
    static int max = 0;
    static int answer = 0 ;
    static boolean[] ban;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = 0 ;
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
            if(segments[i][1] > max){
                max = segments[i][1];
            }
        }
        boolean[] visited = new boolean[max+1];
        ban = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            for(int m = 0 ; m < n; m++){
                if(m==i){
                    continue;
                }
                if(segments[i][0]<=segments[m][0] && segments[i][1]>=segments[m][1]){
                    ban[i] = true;
                }
            }
        }
        dfs(0, visited, 0);


        System.out.println(answer);
    }

    public static void dfs(int num, boolean[] visited, int cnt){
        if(num>=n){
            answer = answer > cnt ? answer : cnt;
            return;
        }
        if(ban[num]==true){
            dfs(num+1,visited,cnt);
        }else{
            int[] now = segments[num];
            int l = now[0];
            int r = now[1];

            dfs(num+1, visited, cnt);

            if(visited[l] == false && visited[r] == false){
                for(int i = l ; i <= r; i++){
                    visited[i] = true;
                }
                dfs(num+1, visited, cnt+1);
                for(int i = l ; i <= r; i++){
                    visited[i] = false;
                }
            }
        }
        
    }
}
