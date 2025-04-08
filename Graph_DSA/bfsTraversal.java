import java.util.*;

class Solution{
	public static ArrayList<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> adj, int v){
		// creating visiting array vis[]
		boolean[] vis = new boolean[v];
		vis[0] = true;
		// storing the node value in stack
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		// creating ans list 
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()){
			int node = q.poll();
			ans.add(node);
			for(Integer it: adj.get(node)){
				if(vis[it] == false){
					vis[it] = true;
					q.offer(it);
				}
			}
		}

		return ans;
	}
}

class Answer{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 5, m = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		// intitializing the list
		for(int i = 0; i< n; i++){
			adj.add(new ArrayList<Integer>());
		}

		// creation of the adjacent list
		for(int i = 0; i<m; i++){
			int u, v;
			u = s.nextInt();
			v = s.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		s.close();

		// calling the method for bfs traversal:
		List<Integer> bfs = Solution.bfsTraversal(adj, n);
		System.out.println("Element in bfs traversed order: " + bfs);
	}
}