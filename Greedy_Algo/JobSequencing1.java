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
	static int[] JobSequencing(Job[] arr, int n){
		Arrays.sort(arr, (a,b) -> Integer.compare(b.profit, a.profit));

		int deadline = 0;
		for(int i = 0; i < n ; i++)
			deadline = Math.max(deadline,  Job.get(i).dead);

		int[] task = new int[deadline+1]{0};
		int[] ans = {0, 0};

		for(int i = 0; i < n; i++){
			for(int j = arr[i].dead; j > 0; j--){
				if(task[j] == 0){
					task[j] = 1;
					ans[0]+=1;
					ans[1] = ans[1] + arr[i].profit;
					break;
				}
			}
		}

 		return ans;
	}
}

public class JobSequencing1{
	public static void main(String[] args) {
		
	}
}