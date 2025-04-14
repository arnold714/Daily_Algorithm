import java.util.*;
import java.io.*;
class Solution {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int N, M;
    static int[][] land;
    static int[][] board;
    public int solution(int[][] land) {
        this.land = land;
        int answer = 0;
        this.N = land.length;
        this.M = land[0].length;
        int[][] board = new int[N][M];
        for(int n = 0 ; n < N ; n++){
            for(int m = 0 ; m < M; m++){
                board[n][m] = -1;
            }
        }
        this.board = board;
        for(int n = 0; n < N ; n++){
            for(int m = 0 ; m < M ; m++){
                if(board[n][m] == -1 && land[n][m]==1){
                    bfs(n , m);
                }
            }
        }
        for(int m = 0 ; m < M; m++){
            int tmp = 0;
            for(int n = 0 ; n < N; n++){
                if(board[n][m] > 0){
                    tmp += board[n][m];
                }
            }
            answer = answer > tmp ? answer : tmp;
        }
        return answer;
    }
    public void bfs(int n, int m){
        int cnt = 0;
        int[] visited = new int[M];
        Arrays.fill(visited, -1);
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{n, m});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(board[now[0]][now[1]] != -1){
                continue;
            }
            
            if(visited[now[1]] == -1){
                visited[now[1]] = now[0];
            }else{
                visited[now[1]] = visited[now[1]] < now[0]
                    ? visited[now[1]] : now[0];
            }
            
            board[now[0]][now[1]] = 0;
            cnt++;
            
            for(int i = 0 ; i < 4; i++){
                int xnext = now[0] + dx[i];
                int ynext = now[1] + dy[i];
                
                if(xnext >= 0 && xnext < N 
                   && ynext >= 0 && ynext < M 
                   && land[xnext][ynext] == 1){
                    q.offer(new int[]{ xnext, ynext});
                }
            }
        }
        for(int i = 0 ; i < M; i++){
            if(visited[i] != -1){
                board[visited[i]][i] = cnt;
            }
        }
    }
}