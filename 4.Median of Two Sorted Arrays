/**
	题目要求：
	给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
	请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
	你可以假设 nums1 和 nums2 均不为空。
 */

/**
	解题思路：中位数的左右是长度相等的数组，中位数左边的数皆小于中位数，右边的数皆大于中位数。
	由题可知，nums1和nums2皆已排序。
	假设左右的长度皆为len  （len = (nums1.length+nums2.length)/2;），	
	从nums1取出index个数，从nums2取出len-index个数构成左边数组，剩余数构成右边数组，
	若满足条件：**max(left_array)<=min(right_array)**
	则说明中位数应该为max(left_array)（总个数为奇数的情况）或(max(left_array)+min(right_array))/2（总个数为偶数的情况）
	
	Other:代码中存在大量重复，有进一步优化的空间。
	
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = (nums1.length+nums2.length)/2;
        int[] tmp1 = new int[len+1];
        int[] tmp2 = new int[len];
        int maxL=0, minR=(nums2.length>0)?nums2[nums2.length-1]:nums1[nums1.length-1];
        if(nums1.length>0){
            if(minR<nums1[nums1.length-1])
                minR=nums1[nums1.length-1];
        }
        int tmpMinR=minR;
        if((nums1.length+nums2.length)%2==0){
            int index=0;
            while(true){
                if(nums1.length<=nums2.length){
                    if(index<=nums1.length){
                        maxL=0;
                        minR = tmpMinR;
                        for(int i=0;i<index;i++){
                            maxL = (nums1[i]>maxL)?nums1[i]:maxL;
                        }
                        for(int j=0;j<len-index;j++){
                            maxL = (nums2[j]>maxL)?nums2[j]:maxL;
                        }
                        for(int i=len-index;i<nums2.length;i++){
                            minR = (nums2[i]<minR)?nums2[i]:minR;
                        }
                        for(int m=index;m<nums1.length;m++){
                            minR = (nums1[m]<minR)?nums1[m]:minR;
                        }
                        if(maxL<=minR){
                            return ((double)maxL+(double)minR)/2;
                        }else{
                            index++;
                        }
                    }else
                        break;
                    
                }else{
                    if(index<=nums2.length){
                        maxL=0;
                        minR=tmpMinR;
                        for(int i=0;i<index;i++){
                            maxL = (nums2[i]>maxL)?nums2[i]:maxL;
                        }
                        for(int j=0;j<len-index;j++){
                            maxL = (nums1[j]>maxL)?nums1[j]:maxL;
                        }
                        for(int i=len-index;i<nums1.length;i++){
                            minR = (nums1[i]<minR)?nums1[i]:minR;
                        }
                        for(int m=index;m<nums2.length;m++){
                            minR = (nums2[m]<minR)?nums2[m]:minR;
                        }
                       
                        if(maxL<=minR){
                            return ((double)maxL+(double)minR)/2;
                        }else{
                            index++;
                        }
                    }else
                        break;
                }   
            }   
        }else{
            int index=0;
            while(true){
                if(nums1.length<=nums2.length){
                    if(index<=nums1.length){
                        maxL=0;
                        minR=nums2[nums2.length-1];
                        for(int i=0;i<index;i++){
                            maxL = (nums1[i]>maxL)?nums1[i]:maxL;
                        }
                        for(int j=0;j<len+1-index;j++){
                            maxL = (nums2[j]>maxL)?nums2[j]:maxL;
                        }
                        for(int i=len+1-index;i<nums2.length;i++){
                            minR = (nums2[i]<minR)?nums2[i]:minR;
                        }
                        for(int m=index;m<nums1.length;m++){
                            minR = (nums1[m]<minR)?nums1[m]:minR;
                        }
                        
                        if(maxL<=minR){
                            return maxL;
                        }else{
                            index++;
                        }
                    }else
                        break;
                    
                }else{
                    if(index<=nums2.length){
                        maxL=0;
                        minR=nums1[nums1.length-1];
                        for(int i=0;i<index;i++){
                            maxL = (nums2[i]>maxL)?nums2[i]:maxL;
                        }
                        for(int j=0;j<len+1-index;j++){
                            maxL = (nums1[j]>maxL)?nums1[j]:maxL;
                        }
                        for(int i=len+1-index;i<nums1.length;i++){
                            minR = (nums1[i]<minR)?nums1[i]:minR;
                        }
                        for(int m=index;m<nums2.length;m++){
                            minR = (nums2[m]<minR)?nums2[m]:minR;
                        }
                       
                        if(maxL<=minR){
                            return maxL;
                        }else{
                            index++;
                        }
                    }else
                        break;
                }   
            }   
        }
        return 0;
    }
}