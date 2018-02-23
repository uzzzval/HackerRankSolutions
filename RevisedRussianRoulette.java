import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] revisedRussianRoulette(int[] doors) {
     
        int min=0;
        int max=0;
        int[] returnArray=new int[2];
        
        if(doors.length==1 && doors[0]==1) {returnArray[0]=1;returnArray[1]=1; return returnArray;} 
        
        for(int i=0;i<doors.length;i++){
            if(doors[i]==1)
                max++;
        }
        
        for(int i=0;i<doors.length-1;i++){
            if(doors[i]==1 && doors[i+1]==1){
                doors[i]=0;
                doors[i+1]=0;
                min++;
            }else if(doors[i]==1 && doors[i+1]==0){
                doors[i]=0;
                min++;
            }
            
        }
        if(doors[doors.length-1]==1)min++;
        returnArray[0]=min;
        returnArray[1]=max;
        return returnArray;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        in.close();
    }
}
