import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Meeting{
	int start;
	int end;
	int posti;
	Meeting(int start, int end, int posti){
		this.start = start;
		this.end = end;
		this.posti = posti;
	}
}

class Implementation{
	public static int maxMeeting(int[] start, int[] end){
		List<Meeting> res = new ArrayList<>();
		int n = start.length;
		for(int i =0; i<n; i++)
			res.add(new Meeting(start[i], end[i], i));

		res.sort((m1, m2) -> Integer.compare(m1.end, m2.end)); // Lambda expression
		int curr = 0;
		int maxM = 0;
		for(int i =0; i<n; i++){
			if(res.get(i).start > curr){
				maxM++;
				curr = res.get(i).end;
			}
			
		}

		return maxM;
	}
}

class nMeeting{
	public static void main(String[] args) {
		int[] start = {1, 3, 2, 5,  8, 5};
		int[] end = {2, 4, 6, 7, 9, 9};

		int maxNoMeeting = Implementation.maxMeeting(start, end);
		System.out.println("Max. No. of metting can be conductd: " + maxNoMeeting);
	}
}