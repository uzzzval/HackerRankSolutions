import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMinimumUniqueSum {

	public static void main(String[] args) {
		int[] myIntArray = new int[]{2,2,4,5};
		List<Integer> myList = new ArrayList<Integer>();
		for(int i = 0;i<myIntArray.length;i++) {
			myList.add(myIntArray[i]);
		}
		Collections.sort(myList);
		for(int i=0;i<myList.size()-1;i++) {
			if(myList.get(i)==myList.get(i+1)) {
				myList.set(i+1, myList.get(i+1)+1);
			}
		}
		int totalsum = 0;
		for(int i=0;i<myList.size();i++) {
			totalsum = totalsum+myList.get(i);
		}
		System.out.println(totalsum);
	}

}
