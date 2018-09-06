/**
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList(), candidates, target, 0);
        
        return list;
    }
    
    public static boolean backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain<0)    
            return false;
        else if(remain==0){
            list.add(new ArrayList<>(tempList));
            return false;
            
        }else{
            for(int i=start; i<nums.length; i++){
                boolean flag;
                tempList.add(nums[i]);
                flag = backtrack(list, tempList, nums, remain-nums[i], i);
                tempList.remove(tempList.size()-1);
                
                if(!flag){
                    break;
                }
            }
            return true;
        }
    }
}