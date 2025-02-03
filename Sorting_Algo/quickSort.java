class Qsort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; 
        int i = low + 1;  
        int j = high;

        while (i <= j) {
            while (i <= high && arr[i] <= pivot) i++;  
            while (j > low && arr[j] > pivot) j--; 

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j); 

        return j; 
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) { 
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
}

class Implementation {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 7, 2, 9, 5};
        System.out.print("Array before sorting: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        Qsort.quickSort(arr, 0, arr.length - 1);

        System.out.print("Array after sorting: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
