package xiecheng;
import java.util.*;

public class tanxin {
    public  static  void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext()) {
            sc.close();
            return;
        }
        int T = sc.nextInt();
        while(T--!=0){
            int n = sc.nextInt();
            String s = sc.next();
            int []a = new int[n];
            for(int i =0;i<n;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int [] ans = new int [n];
            int left = 0;
            int right = n-1;
            int i =0;
            while (i < n){
                int j = i;
                while(j+1<n&&s.charAt(j+1)==s.charAt(i)) j++;
                if(j+1==n){
                    for(int k =i;k<=j;k++) ans[k] = a[left++];
                }else if(s.charAt(i)<s.charAt(j+1)){
                    for(int k =i;k<=j;k++) ans[k] = a[right--];
                }else{
                    for(int k =i;k<=j;k++) ans[k] = a[left++];
                }
                i = j+1;
            }
            StringBuilder sb = new StringBuilder();
            for(int l =0;l<n;l++){
                sb.append(ans[l]).append(l==n-1?"":" ");
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
