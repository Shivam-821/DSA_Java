class MaxHeap{

	int[] arr;
	int size;
	int capacity;

	MaxHeap(int n){
		arr = new int[n];
		size = 0;
		capacity = n;
	}

	void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void insert(int value){
		if(size == capacity){
			System.out.println("Heap Overflow!");
			return;
		}

		arr[size] = value;
		int index = size;
		size++;

		// compare it with it's parent:
		while(index>0 && arr[(index-1)/2] < arr[index]){
			swap(arr, index, (index-1)/2);
			index = (index-1)/2;
		}

		System.out.println(value + " is inserted into the heap");
	}

	void printHeap(){
		// for(int x: arr){
		// 	System.out.print(x + " ");
		// }
		for(int i = 0; i < size; i++){
			System.out.print(arr[i] + " ");;
		}
		System.out.println();
	}

	void Heapify(int index){
		int largest = index;
		int left = 2*index + 1;
		int right = 2*index + 2;

		// largest will store the index of the element
		if(left < size && arr[left]>arr[largest])
			largest = left;
		if(right < size && arr[right] > arr[largest])
			largest = right;

		if(largest != index){
			swap(arr, index, largest);
			Heapify(largest);
		}
	}

	void Delete(){
		if(size == 0) {
			System.out.println("Heap underflow!");
			return;
		}
		System.out.println(arr[0] + "is deleted from the heap");
		arr[0] = arr[size-1];
		size--;

		if(size == 0)
			return;
		Heapify(0);
	}

}

class Implementation{
	public static void main(String[] args){
		MaxHeap mh = new MaxHeap(15);
		mh.insert(12);
		mh.insert(10);
		mh.insert(2);
		mh.printHeap();
		mh.insert(25);
		mh.Delete();
		mh.insert(14);
		mh.insert(10);
		mh.printHeap();
		mh.Delete();
		mh.printHeap();
	}
}