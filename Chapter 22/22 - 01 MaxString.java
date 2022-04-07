package dsandalgs;
import java.util.*;
public class MaxString {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = input.next();
		
		LinkedList<Character> list = new LinkedList<>();
		LinkedList<Character> max = new LinkedList<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (list.size() > 1 && s.charAt(i) <= list.getLast() && list.contains(s.charAt(i))) {
				list.clear();
			}
			list.add(s.charAt(i));
			if (list.size() >= max.size()) {
				max.clear();
				max.addAll(list);
			}
		}
		System.out.print("Maximum consecutive substring is ");
		for(Character ch : max) {
			System.out.print(ch);
		}
	}
}
