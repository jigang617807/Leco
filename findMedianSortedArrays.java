/* 
class findMedianSortedArrays{
    //合并两个数组？
    public static void main(String[]args) {
        
        
    }
    public static float solution(int[] nums1,int[]nums2){
        if(nums1.length==0&&nums2.length==0){
            return 0;
        }
        if(nums1.length==0){
            int n = nums2.length;
            if(n%2==0){
                return (nums2[n/2-1]+nums2[n/2]) /2;
            }else{
                return nums2[n/2];
            }
        }
        if(nums2.length==0){
            int n = nums2.length;
            if(n%2==0){
                return (nums2[n/2-1]+nums2[n/2]) /2;
            }else{
                return nums2[n/2];
            }
        }
        return 0; 
    }


}
*/