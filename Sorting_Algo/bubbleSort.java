class Bsort{
	static int[] bubbleSort(int[] arr){
		int n = arr.length;
		for(int i = 1; i <= n-1 ; i++){
			boolean flag =  false;
			for(int j = 0; j <= n-i-1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(flag == false){
				break;
			}
		}

		return arr;
	}
}

class Implementation{
	public static void main(String[] args) {  

		// Another way to pass array as an argument.
		int[] arr = Bsort.bubbleSort(new int[] {3, 6, 1, 7, 2, 9, 5});
		System.out.println("Array after sorting: ");
		for(int x: arr){
			System.out.print(x+ " ");
		}
	}
}