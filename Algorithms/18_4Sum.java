/**
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList();
        if (nums == null || nums.length < 4)
			return ret;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++){
            if(target>0&&nums[i]>target || target<0&&nums[i]>0) break;
            if (i > 0 && nums[i] == nums[i - 1])
				        continue;
            for(int j=i+1;j<nums.length;j++){
                if (j > i+1 && nums[j] == nums[j - 1])
				        continue;
                int l=j+1,r=nums.length-1;
                while(l<r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ret.add(list);
                        
                        l++;
                        r--;
                        while(l<r&&nums[l]==nums[l-1]){
                            l++;
                        }
                        while(l<r&&nums[r]==nums[r+1]){
                            r--;
                        }
                    }else if(sum<target){
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