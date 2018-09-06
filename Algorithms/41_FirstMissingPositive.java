/**
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间
*/

/**
思路：
1.使用桶排序，对原数组排序。把对应的值放在对应的位置上，比如把1放在索引0处，2放在索引1处。
  使得目前存在的正整数满足：nums[i] =i+1。最后遍历数组，第一个不匹配的的值就是没有出现的最小整数值。
2. 几种不能交换的情况要考虑：
    1) nums[i]>nums.length-1，此时如果交换会造成IndexOutOfBounds
    2) nums[i]<=0，理由同上
    3) nums[nums[i]-1]==nums[i]，即要交换位置的值已经是对应好的了，此时无需多此一举。
3. 存在一种可能，排完序后，所有的值都匹配，此时要返回最大值+1
*/

class Solution {
     public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i+1){
                if(nums[i]>nums.length-1||nums[i]<=0||nums[nums[i]-1]==nums[i]){
                    break;
                }
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        int res = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }else{
                res++;
            }
        }
        return res;
    }
}