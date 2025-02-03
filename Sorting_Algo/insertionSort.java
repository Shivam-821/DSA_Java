class Isort{
	static void insertionSort(int[] arr){
		int n = arr.length;
		for(int i = 1; i < n; i++){
			int j = i;
			while(j>0 && arr[j] < arr[j-1]){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
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
		Isort.insertionSort(arr);
		System.out.print("Array after sorting: ");
		for(int x: arr){
			System.out.print(x+ " ");
		}
	}
}