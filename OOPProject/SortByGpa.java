package OOPProject;

public class SortByGpa {
	static <E> void swap (E[] array, int i, int j) {
		if(i!=j) {
			E temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	static <E extends Comparable<E>> void bubleSort(E[] array) {
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for(int i=1;i<array.length;i++) {
			if(array[i].compareTo(array[i-1])<0) {
				swapped = true;
				swap(array, i, i-1);
			}
		}
		}
	}
}
