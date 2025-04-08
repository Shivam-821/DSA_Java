// give grid of  (n x m) and we required total time to rotten all oranges and if we are unable to rott all oranges then we need to return -1

// we also need to store time also with row and col 
import java.util.*;

class Pair{
	int first, second, time;
	Pair(int first, int second, int time){
		this.first = first;
		this.second = second;
		this.time = time;
	}
}

class Solution{

	public static int bfs(int[][] arr, int[][] vis, int n, int m){
		Queue<Pair> q = new LinkedList<>();
		int totalTime = 0;
		int freshCount = 0;
		int rottenCount = 0;

		for(int i = 0; i<n; i++){
			for(int j= 0; j<m; j++){
				if(arr[i][j] == 2){
					vis[i][j] = 2;
					q.add(new Pair(i, j, 0));
				}else if (arr[i][j] == 1) {
					freshCount++;
				}
			}
		}

		int[] dRow = {-1, 1, 0, 0};
		int[] dCol = {0, 0, -1, 1};

		while(!q.isEmpty()){
			Pair p = q.poll();
			int row = p.first;
			int col = p.second;
			int time = p.time;
			totalTime = Math.max(totalTime, time);

			for(int i =0; i<4; i++){
				int nrow = row + dRow[i];
				int ncol = col + dCol[i];

				if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] !=2 && arr[nrow][ncol] == 1){
					vis[nrow][ncol] = 2;
					q.add(new Pair(nrow, ncol, time+1));
					rottenCount++;
				}
			}
		}

		return (rottenCount == freshCount) ? totalTime : -1;
	}

	public static int orangesRotting(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;

		// visiting array
		int[][] vis = new int[n][m];

		int time = bfs(arr, vis, n, m);
		return time;
	} 

	public static void main(String args[])
    {
        int arr[][]={ 
        	{2,1,1}, 
        	{1,1,0}, 
        	{0,1,1} 
        };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required: "+rotting);
    }
}