import java.util.*;
public class compareVersion{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  
        int num = sc.nextInt();
        while(num--!=0){
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(comp(s1,s2));  
        }  
        sc.close();
    }
    public static int comp(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int i =0,j=0;
        while(i<n1||j<n2){
            int num1 = 0;
            while(i<n1&&s1.charAt(i)!='.'){
                num1 = num1*10+s1.charAt(i)-'0';
                i++;
            }
            //跳过点号
            i++;
            int num2 = 0;
            while(j<n2&&s2.charAt(j)!='.'){
                num2 = num2*10+s2.charAt(j);
                j++;
            }
            j++;
            if(num1>num2) return 1;
            else if(num1<num2) return -1;
        }
        return 0;
    }
}