package dsandalgs;

import java.util.*;

public class WordOccurrence implements Comparable<WordOccurrence> {
String word;
int count;

public WordOccurrence(String word, int count) {
	this.word = word;
	this.count = count;
}




@Override
public int compareTo(WordOccurrence o) {
	if(count > o.count) {
		return 1;
	}
	if (count < o.count) {
		return -1;
	}
	else return 0;
 	}
@Override
public String toString() {
	return  word + ": " + count;
}
}
