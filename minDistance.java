import java.util.*;
/*
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符
*/
public class minDistance {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num--!=0){
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(minEditLength(s1, s2));
        }
        sc.close();
    }
    private static int minEditLength(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        //word1前i个到word2前j个的距离
        int [][]dp = new int[n+1][m+1];
        //word2空 word1全删
        for(int i=1;i<=n;i++) dp[i][0] = i;
        //word1空，word1全加
        for(int j =1;j<=m;j++) dp[0][j] = j;

        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
            }
        }
        return dp[n][m];
    }
    
}