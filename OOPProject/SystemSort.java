package OOPProject;

public class SystemSort {
	static void Sort(String[] arr, int low, int high){
		if (low < high) {
			int pi = partition(arr, low, high);
			Sort(arr, low, pi - 1);
			Sort(arr, pi + 1, high);
		}
	}
	
	
	static void Sort(String[] arr){
		int low = 0;
		int high = arr.length-1;
		if (low < high) {
			int pi = partition(arr, low, high);
			Sort(arr, low, pi - 1);
			Sort(arr, pi + 1, high);
		}
	}
	
	
	static void Sort(double[] arr, int low, int high){
		if (low < high) {
			int pi = partition(arr, low, high);
			Sort(arr, low, pi - 1);
			Sort(arr, pi + 1, high);
		}
	}
	
	
	static void Sort(double[] arr){
		int low = 0;
		int high = arr.length-1;
		if (low < high) {
			int pi = partition(arr, low, high);
			Sort(arr, low, pi - 1);
			Sort(arr, pi + 1, high);
		}
	}
	
	
	static void swap(double[] arr, int i, int j){
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	static void swap(String[] arr, int j, int i) {
		String temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
	}
	
	
	static int partition(double[] arr, int low, int high){
		double pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	
	
	static int partition(String[] arr, int low, int high){
		String pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j].compareTo(pivot) <= 0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	
	
	public static void printArr(String[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void printArr(double[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}