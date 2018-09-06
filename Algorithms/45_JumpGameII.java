/**
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。
*/

/**
思路：递归+贪心算法
遍历当前跳跃能到的所有位置，然后根据该位置上的跳力来预测下一步能跳到的最远距离。
贪出一个最远的范围，一旦当这个范围到达末尾时，当前所用的步数一定是最小步数。
*/

class Solution {
    public int jump(int[] nums) {
        int res = jumpToEnd(nums, 0, 0);
        return res;
    }
    
    public static int jumpToEnd(int[] nums, int ind, int steps){
        if(ind>=nums.length-1){
            return steps;
        }
        if(ind+nums[ind]>=nums.length-1){
            return steps+1;
        }
        int val = nums[ind];
        
        int ind2 = 1;
        for(int i=2;i<=val;i++){
            if(ind+i>=nums.length){
                break;
            }
            if(i+nums[ind+i]>ind2+nums[ind+ind2]){
                ind2 = i;
            }
        }
        int tmp = jumpToEnd(nums, ind+ind2, steps+1);
        return tmp;
    }
}