import java.util.*;

class Job{
	int job_id;
	int dead;
	int profit;
	Job(int job_id, int deadline, int profit){
		this.job_id = job_id;
		this.dead = dead;
		this.profit = profit;
	}
}

class Implementation{

	static int findSlot(){}
	static int[] maxProfit(Job[] arr, int n){
		Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));

		int deadline = 0;
		for(int i =0; i<n; i++){
			deadline = Math.max(deadline, Job[i].dead);
		}
		int[] parent = new int[n];
		for(int i =0; i<n; i++){
			parent[i] = i;
		}

		int[] ans= {0, 0};

		for(int i =0; i<n; i++){
			int slot = findSlot()
		}
	}
}

class JobSequencing2{
	public static void main(String[] args) {
		
	}
}