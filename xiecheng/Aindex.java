package xiecheng;
import java.util.Scanner;
public class Aindex {
    //新增了改动！
    public static void main(String[] args) {
        // 创建 Scanner 对象用于读取标准输入
        Scanner sc = new Scanner(System.in);
        
        // ACM 模式标准写法：使用 while 处理可能存在的多组输入
        while (sc.hasNext()) {
            // 读取输入的字符串
            String s = sc.next();
            
            // indexOf('a') 获取 'a' 的 0 基索引
            // 题目要求下标从 1 开始，因此结果需要 +1
            System.out.println(s.indexOf('a') + 1);
        }
        
        // 释放资源（好习惯）
        sc.close();
    }
}


