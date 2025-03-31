import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class mincoin{

	static List<Integer> findMinCoin(int amt, int[] arr){
		int i = 0;
		List<Integer> ans = new ArrayList<>();
		while(amt > 0 && i < arr.length){
			int noOfTimes = amt / arr[i];
			while(noOfTimes > 0){
				ans.add(arr[i]);
				noOfTimes--;
			}
			amt = amt % arr[i];
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the Amount: ");
		int amt = s.nextInt();
		List<Integer> coin = new ArrayList<>();
		coin = findMinCoin(amt, arr);
		System.out.print("These are the coin: ");
		for(int x: coin){
			System.out.print(x + " ");
		}
		
		s.close();
	}
}