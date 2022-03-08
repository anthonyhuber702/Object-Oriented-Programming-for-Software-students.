package generics;
import java.util.ArrayList;

public class DistinctArrayList {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
	     ArrayList<E> list1 = new ArrayList<>(list.size());
	     
	        for (E temp : list) {
	            if (!list1.contains(temp)) {
	                list1.add(temp);
	            }
	        }
	        return list1;
	    }
	}