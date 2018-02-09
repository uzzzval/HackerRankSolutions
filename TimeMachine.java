import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner reader=new Scanner(System.in);
        String msg=reader.nextLine();
        Queue<List<Integer>> queue = new LinkedList<>();
		List<Integer> list;
		int toBeAdded = 0;
		
		for(int i=msg.length()-1; i>=0; i--) {
			list = new ArrayList<>();
			if(!queue.isEmpty() && queue.peek().get(0) == i) {
				if(msg.charAt(i) == '*') {
					list.add(i-2);
					list.add(queue.peek().get(1)*2);
					queue.add(list);
				}else {
					if(msg.charAt(i) == '<') toBeAdded += -1 * queue.peek().get(1);
					else toBeAdded += 1 * queue.peek().get(1);
				}
				queue.poll();
			}else {
				if(msg.charAt(i) == '*') {
					list.add(i-2);
					list.add(2);
					queue.add(list);
				}else {
					if(msg.charAt(i) == '<') toBeAdded += -1;
					else toBeAdded += 1;
				}
			}
		}
		System.out.print(2017 + toBeAdded);
    }
}
