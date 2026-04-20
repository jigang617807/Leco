package xiecheng;
import java.util.*;

public class totalScore {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int T = sc.nextInt();
        // 核心数据结构设计
        // 1. 记录总分：索引是 userId (1~100)，值是该用户的总分。大小开 101 防越界。
        int[] totalScores = new int[101];
        
        // 2. 记录每道题的最高分：数组套 Map。
        // 数组索引是 userId，Map 的 key 是 problemId，value 是对应的最高分。
        Map<Integer, Integer>[] userProblemScores = new HashMap[101];
        for (int i = 1; i <= 100; i++) {
            userProblemScores[i] = new HashMap<>();
        }
        //处理每一次提交
        while(T--!=0){
            int userId = sc.nextInt();
            int problemId  = sc.nextInt();
            int score = sc.nextInt();
            // 获取该用户这道题的历史最高分（如果之前没做过这题，默认是 0）
            int oldMaxScore = userProblemScores[userId].getOrDefault(problemId, 0);
            if(score>oldMaxScore){
                userProblemScores[userId].put(problemId,score);
                totalScores[userId] += (score-oldMaxScore);
            }
            int currentTotal = totalScores[userId];
            int rank = 1;
            for(int j =1;j<=100;j++){
                if(totalScores[j]>currentTotal){
                    rank++;
                } 
            }
            System.out.println(rank);
        }
        sc.close();
    }
}