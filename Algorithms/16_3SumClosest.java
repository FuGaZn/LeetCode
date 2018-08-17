/**
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;
        if(nums==null||nums.length<3)   return ret;    
        Arrays.sort(nums);
        
        int cha = abs(nums[0]+nums[1]+nums[2]-target);
        
        for(int i = 0;i<nums.length;i++){
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(abs(sum-target)<=cha){
                    ret = sum;
                    cha = Math.abs(sum-target);
                    if (sum<=target){
                        l++;
                    }else{
                        r--;
                    }
				}else{
                    if (sum<=target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return ret;
    }  
}