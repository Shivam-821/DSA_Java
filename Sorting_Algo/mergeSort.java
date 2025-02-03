import java.util.ArrayList;

class Msort{
	public static void mergeSort(int[] arr, int low, int high){
		if(low >=  high) return;
			int mid =  (low + high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
	}
	public static void merge(int[] arr, int low, int mid, int high){
		int left = low;
		int right = mid+1;
		ArrayList<Integer> al = new ArrayList<>();

		while(left <= mid && right <= high){
			if(arr[left] > arr[right]){
				al.add(arr[right]);
				right++;
			}else{
				al.add(arr[left]);
				left++;
			}
		}

		while(left <= mid){
			al.add(arr[left]);
			left++;
		}
		while(right <= high){
			al.add(arr[right]);
			right++;
		}

		for(int i =low; i <= high; i++){
			arr[i] = al.get(i - low);
		}
	}
}

class Implementation{
	public static void main(String[] args) { 
		int[] arr = {3, 6, 1, 7, 2, 9, 5};
		System.out.print("Array before sorting: ");
		for(int x: arr){
			System.out.print(x+ " ");
		}
		Msort.mergeSort(arr, 0, arr.length-1);
		System.out.print("Array after sorting: ");
		for(int x: arr){
			System.out.print(x+ " ");
		}
	}
}