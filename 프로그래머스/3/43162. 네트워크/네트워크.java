class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        answer = 0;
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i,computers, n);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int i, int[][] computers, int n){
        for(int j = 0 ; j < n; j++){
            if(computers[i][j]==1 && !visited[j]){
                visited[j]=true;
                dfs(j, computers, n);
            }
        }
    }
}