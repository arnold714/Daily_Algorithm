import java.util.*;
import java.io.*;

class Solution {
    static int n, len, answer = 0;
    static int[][] q;
    static int[] ans, visited;
    static boolean[] selected;
    
    public int solution(int n, int[][] q, int[] ans) {
        Solution.n = n;
        Solution.q = q;
        Solution.ans = ans;
        selected = new boolean[n+1];
        len = q.length;
        
        loop();
        
        return answer;
    }
    
    public static void check(){
        //ans의 길이만큼 반복
        for(int i = 0 ; i < len ; i++){
            //q[] 의 길이 만큼 반복
            int sum = 0;
            for(int j = 0 ; j < 5; j++){
                if(selected[q[i][j]]==true){
                    sum++;
                }
            }
            if(sum != ans[i]){
                break;
            }
            if(i==len-1){
                answer++;
            }
        }
    }
    
    public static void loop(){
        for(int a = 1; a <= n - 4; a++){
            selected[a] = true;
            for(int b = a + 1; b <= n - 3; b++){
                selected[b] = true;
                for(int c = b + 1; c <= n - 2; c++){
                    selected[c] = true;
                    for(int d = c + 1; d <= n - 1; d++){
                        selected[d] = true;
                        for(int e = d + 1; e <= n; e++){
                            selected[e] = true;
                            check();
                            selected[e] = false;
                        }
                        selected[d] = false;
                    }
                    selected[c] = false;
                }
                selected[b] = false;
            }
            selected[a] = false;
        }
    }
}