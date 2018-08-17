/**
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

*/

/**
1. 拒绝暴力的三层嵌套循环，先排序，再采用双层循环。从左右向内逼近寻找合适的值
2. 尽量减少无用的访问过程，对于和上一次遍历遇到的相同的值，忽略掉，从而减少时间开支。
3. 当三个数的最左侧的数（即最小值）已经大于0时，停止遍历。
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        
        if (nums == null || nums.length < 3)
			return ret;
        
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
            
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ret.add(list);
                    
                    l++;
					r--;
					while (l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                        
					while (l < r && nums[r] == nums[r + 1]){
                        r--;
                    }
                    
                }else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
            
        }
        return ret;
    }   
}