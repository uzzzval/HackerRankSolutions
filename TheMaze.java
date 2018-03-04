import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner reader=new Scanner(System.in);
		int rows=Integer.parseInt(reader.nextLine());
		
		String inputString=reader.nextLine();
		
		int columns=inputString.length();

		char maze[][]=new char[rows][columns];
		char character;
		int startX=0,startY = 0;
		
		for(int i=0;i<columns;i++){
			character=inputString.charAt(i);
			maze[0][i]=character;
			if(character=='S')
				startY=i;
		}
		
		for (int j=1;j<rows;j++){
			inputString=reader.nextLine();
			columns=inputString.length();
			for(int i=0;i<columns;i++){
				character=inputString.charAt(i);
				maze[j][i]=character;
				if(character=='S'){
					startY=i;
                    startX=j;
                }
			}
		}
		
		printPath(startX, startY, maze, "");
		
	}
	
	public static void printPath(int startX,int startY, char[][] maze, String path) {
		

		if(maze[startX][startY]=='F'){
			System.out.println(path);
			return;
		}
		
		maze[startX][startY]='@';
		
		if(startX>0 && maze[startX-1][startY]!='@')
			printPath(startX-1, startY, maze, path+"U");
		
		if(startX<maze.length-1 && maze[startX+1][startY]!='@')
			printPath(startX+1, startY, maze, path+"D");
		
		if(startY>0 && maze[startX][startY-1]!='@')
			printPath(startX, startY-1, maze, path+"L");
		
		if(startY<maze[0].length-1 && maze[startX][startY+1]!='@')
			printPath(startX, startY+1, maze, path+"R");
	
    }
}
