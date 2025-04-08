import java.util.*;

class Solution{

	public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] vis, int node){
		vis[node] = true;
		ans.add(node);
		for(Integer it: adj.get(node)){
			if(vis[it] == false){
				dfs(adj, ans, vis, it);
			}
		}
	}

	public static ArrayList<Integer> dfsTraversal(ArrayList<ArrayList<Integer>> adj, int v){

		// creation of visiting array vis[]
		boolean[] vis = new boolean[v];
		int startingNode = 0;
		ArrayList<Integer> ans = new ArrayList<>();

		dfs(adj, ans, vis, startingNode);

		return ans;
	}
}

class Answer{
	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		// creating adjacent list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i<n; i++){
			adj.add(new ArrayList<Integer>());
		}

		// taking m lines input 
		for(int i = 0; i<m; i++){
			int u = s.nextInt();
			int v = s.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		s.close();

		List<Integer> dfs = Solution.dfsTraversal(adj, n);
		System.out.println("Element in dfs traversed order: " + dfs);
	}
}