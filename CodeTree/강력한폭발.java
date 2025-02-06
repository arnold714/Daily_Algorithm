import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]> list;
    static int answer = 0;
    static int N;
    static int len = 0;
    static int[][] board;
    static int[] dx1 = new int[] {-2, -1, 1, 2};
    static int[] dy1 = new int[] {0, 0, 0, 0};
    
    static int[] dx2 = new int[] {-1, 0, 1, 0};
    static int[] dy2 = new int[] {0, 1, 0, -1};
    
    static int[] dx3 = new int[] {-1, -1, 1, 1};
    static int[] dy3 = new int[] {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        list = new ArrayList<int[]>();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    list.add(new int[]{i,j});
                    len++;
                }
            }
        }
        //System.out.println(Arrays.deepToString(board));
        dfs(0);
        
        System.out.println(answer);
    }

    public static void dfs(int num){
        if(num >= len){
            int sum = checksum();
            
            // System.out.println(Arrays.deepToString(board));
            if(answer < sum){
                answer = sum;
            }
            return;
        }
        int[] now = list.get(num);
        for(int t = 1 ; t <= 3; t++){
            bomb(t, now, 0);
            dfs(num+1);
            bomb(t, now, 1);
        }
    }

    public static void bomb(int type, int[] now, int goorback){
        if(type==1){
            for(int d = 0 ; d < 4 ; d ++){
                int next_x = now[0] + dx1[d];
                int next_y = now[1] + dy1[d];
                if(goorback==0){
                    if( next_x >= 0 && next_x < N && next_y >=0 && next_y < N && board[next_x][next_y] != 1){
                        board[next_x][next_y]--;
                    }
                }else{
                    if( next_x >= 0 && next_x < N && next_y >=0 && next_y < N && board[next_x][next_y] < 0){
                        board[next_x][next_y]++;
                    }
                }

            }
        }else if(type==2){
            for(int d = 0 ; d < 4 ; d ++){
                int next_x = now[0] + dx2[d];
                int next_y = now[1] + dy2[d];

                if(goorback==0){
                    if( next_x >= 0 && next_x < N && next_y >=0 && next_y < N && board[next_x][next_y] != 1){
                        board[next_x][next_y]--;
                    }
                }else{
                    if( next_x >= 0 && next_x < N && next_y >=0 && next_y < N && board[next_x][next_y] < 0){
                        board[next_x][next_y]++;
                    }
                }
            }
        }else if(type==3){
            for(int d = 0 ; d < 4 ; d ++){
                int next_x = now[0] + dx3[d];
                int next_y = now[1] + dy3[d];

                if(goorback==0){
                    if( next_x >= 0 && next_x < N && next_y >=0 && next_y < N && board[next_x][next_y]!= 1){
                        board[next_x][next_y]--;
                    }
                }else{
                    if( next_x >= 0 && next_x < N && next_y >=0 && next_y < N && board[next_x][next_y] < 0){
                        board[next_x][next_y]++;
                    }
                }
            }
        }
    }

    
    public static int checksum(){
        int sum = 0; 
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(board[i][j] != 0){
                    sum ++;
                }
            }
        }
        return sum;
    }
}
