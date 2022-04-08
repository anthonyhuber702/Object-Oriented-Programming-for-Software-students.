package dsandalgs;
import java.util.Comparator;

public class GenericQuickSort {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }  
  }
  public static <E extends Comparable<E>> void quickSort(E[] list) {
	  quickSort(list, 0, list.length - 1);
  }
  public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
	  if (last > first) {
		  int pivotIndex = partition(list, first, last);
		  quickSort(list, first, pivotIndex - 1);
		  quickSort(list, pivotIndex + 1, last);
	  }
  }
  public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
	  E pivot = list[first];
	  int low = first + 1;
	  int high = last;
	  
	  while (high > low) {
		  while (low <= high && list[low].compareTo(pivot) <= 0) {
			  high--;
		  }
		  
		  if (high > low) {
			  E temp = list[high];
			  list[high] = list[low];
			  list[low] = temp;
		  }
	  }
	  while (high > first && list[high].compareTo(pivot) <= 0) {
		  high--;
	  }

	  if(pivot.compareTo(list[high]) > 0) {
		  list[first] = list[high];
		  list[high] = pivot;
		  return high;
	  }
	  else return first;
  }
  public static <E> void quickSort(E[] list, Comparator<? super E> i) {
	  quickSort(list, 0, list.length - 1, i);
  }
  public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> i) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, i);
			quickSort(list, first, pivotIndex - 1, i);
			quickSort(list, pivotIndex + 1, last, i);
		}
	}
	public static <E> int partition(E[] list, int first, int last, Comparator<? super E> i) {
		E pivot = list[first];
		int low = first + 1;
		int high = last;
		
		while (high > low) 
			while (low <= high && i.compare(list[low], pivot) <= 0) {
				low++;
			}
			while (low <= high && i.compare(list[high], pivot) > 0) {
				high--;
			}
			
			
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		
		while (high > first && i.compare(list[high], pivot) >= 0) {
			high--;
		}

		if (i.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}
}