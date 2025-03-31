import java.util.*; // This is not a good practice

class Implementation{
	public static List<List<Integer>> non_overlap(int[] start, int[] end){
		List<List<Integer>> l = new ArrayList<>();
		int n = start.length;
		for (int i = 0; i<n; i++){
			l.add(Arrays.asList(start[i], end[i]));
		}

		l.sort(Comparator.comparingInt(a -> a.get(1)));

		List<List<Integer>> ans = new ArrayList<>();
		int last = 0;
		for(List<Integer> interval: l){
			if(interval.get(0) >= last){
				ans.add(interval);
				last = interval.get(1);
			}
		}

		return ans;
	}
}

class NonOverlappingInterval{
	public static void main(String[] args) {
		int[] start = {5, 1, 2, 1, 6, 3};
		int[] end = {6, 4, 4, 2, 8, 7};

		List<List<Integer>> ans = Implementation.non_overlap(start, end);
		for(List<Integer> li: ans ){
			System.out.println(li);
			// System.out.println(li.get(0) + " " + li.get(1));
		}
	}
}