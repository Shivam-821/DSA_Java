class Ssort{
	static void selectionSort(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			int minIn = i;
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[minIn])
					minIn = j;
			}
			if(minIn != i){
				int temp = arr[i];
				arr[i] = arr[minIn];
				arr[minIn] = temp;
			}
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
		Ssort.selectionSort(arr);
		System.out.print("Array after sorting: ");
		for(int x: arr){
			System.out.print(x+ " ");
		}
	}
}