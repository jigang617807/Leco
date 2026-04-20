
import java.util.*;

public class MaxComSubstr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        while(nums--!=0){
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(maxCom(s1,s2));

        }
        sc.close();
    }
    private static int maxCom(String s1, String s2){

        int m = s1.length();
        int n = s2.length();
        int [][]dp = new int[m+1][n+1];
        for(int i =1;i<=m;i++){
            for(int j =1;j<=n;j++){
                //为了方便处理下界问题，这里统一把dp的索引+1，也就是说dp-1是实际的字符串索引
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
