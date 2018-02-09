import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
		
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String values[]=line.split(" ");
        int balance=Integer.parseInt(values[0]);
        int withdraw=Integer.parseInt(values[1]);
        int packets=Integer.parseInt(values[2]);
        
		int coins[]=new int[packets];
        int i=0;
        while(sc.hasNextLine()){
            coins[i]=Integer.parseInt(sc.nextLine());
                i++;
        }
        
        if(balance<withdraw){
            System.out.print("Cannot put into packets");
        }else{
            minCoins_TopDownDP(coins, withdraw,balance);
        }
		
        
	}
	
	public static void minCoins_TopDownDP(int coins[], int value,int balance) {

		//int dp[]=new int[value+1];
		HashMap<Integer, Integer> dp = new HashMap<>();
        
		//for(int i=0;i<dp.length;i++){
		//	dp[i]=-1;
		//}
		boolean[] flag=new boolean[1];
        flag[0]=false;
		minCoins_TopDownDP(coins, value, dp,"",flag);
        
        if(flag[0]){
            System.out.print(balance-value);
        }
        else{
            System.out.print("Cannot put into packets");
        }
	}

	private static int minCoins_TopDownDP(int coins[], int value, HashMap<Integer, Integer> dp, String dist, boolean flag[]) {
		
		if(value==0){
            
			if(!flag[0]){
				flag[0]=true;
				String answer=dist.substring(1);
                String packets[]=answer.split(",");
                HashMap<String,Integer> count=new HashMap<>();
                
                for(int i=0;i<packets.length;i++){
                    if(count.containsKey(packets[i])){
                        count.put(packets[i],count.get(packets[i])+1);
                    }else{
                        count.put(packets[i],1);
                    }
                }
                
                for(int i=0;i<coins.length;i++){
                    if(!count.containsKey(coins[i]+"")){
                        System.out.print(0+":"+coins[i]+" ");
                    }
                    else{
                        System.out.print(count.get(coins[i]+"")+":"+coins[i]+" ");
                    }
			     }
			
                return 0;
		  }
        }
		if(dp.containsKey(value))
			return dp.get(value);

		List<Integer> numberOfCoins=new ArrayList<>();
		for(int i=coins.length-1;i>=0;i--){
			if(value>=coins[i]){
				
				numberOfCoins.add(minCoins_TopDownDP(coins, value-coins[i], dp, dist+","+coins[i],flag));
			}
		}

		int min=Integer.MAX_VALUE;
		int j = -1;
		for(int i=0;i<numberOfCoins.size();i++){
			if(min>numberOfCoins.get(i) && numberOfCoins.get(i)!=Integer.MAX_VALUE){
				min = numberOfCoins.get(i);
				j=i;
			}
		}
		
		if(min!=Integer.MAX_VALUE)
			dp.put(value, min+1);
		
		return (!dp.containsKey(value))?min:dp.get(value);
	}

}
