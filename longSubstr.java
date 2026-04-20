import java.util.*;
public class longSubstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num-->0){
            String s = sc.next();
            System.out.println(MaxLongSubstr(s));

        }
        sc.close();
    }
    private static int  MaxLongSubstr(String s){
        int [] cnt = new int[128]; 
        int maxlen = 0;
        int left = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            cnt[c]++;
            while(cnt[c]>1){
                cnt[s.charAt(left)]--;
                left++;
            }
            if(i-left+1>maxlen){
                maxlen = i-left+1;
            }
        }

        return maxlen;
    }
}
