import java.util.*;

class Answer{	

	public static void dfs(ArrayList<ArrayList<Integer>> adjLs, boolean[] vis, int node){
		vis[node] = true;
		for(Integer it: adjLs.get(node)){
			if(vis[it] == false){
				dfs(adjLs, vis, it);
			}
		}
	}

	public static int noOfProvince(ArrayList<ArrayList<Integer>> adj, int n){
		int count = 0;
		boolean[] vis = new boolean[n];
		int start = 0;

		ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
		for(int i = 0; i < n; i++){
			adjLs.add(new ArrayList<>());
		}

		// firstly need to convert matrix  into list
		for(int i = 0; i< n; i++){
			for(int j =0; j< n;  j++){
				if(adj.get(i).get(j) == 1 &&  i != j){
					adjLs.get(i).add(j);
					adjLs.get(j).add(i);
				} 
			}
		}
		for(int i = 0; i< n; i++){
			if(vis[i] == false){
				count++;
				dfs(adjLs, vis, start);
			}
		}
		return count;
	}

	 public static void main(String[] args){
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>();

        // adjaency matrix
        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
        
        int numPro = noOfProvince(adj, 3);
        System.out.println("No. of Provinces: " + numPro);
    }
}