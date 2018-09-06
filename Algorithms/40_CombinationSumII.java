/**
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。 

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        
        if(candidates==null || candidates.length==0)    return res;
        
        if(target<candidates[0])    return res;
        
        backtrack(res, new ArrayList(), candidates, target, 0);
        
        return res;
    }
    
    public static boolean backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain<0)    
            return false;
        else if(remain==0){
            if(!list.contains(new ArrayList<>(tempList)))
                list.add(new ArrayList<>(tempList));
            return false;
            
        }else{
            for(int i=start; i<nums.length; i++){
                boolean flag;
                tempList.add(nums[i]);
                flag = backtrack(list, tempList, nums, remain-nums[i], i+1);
                tempList.remove(tempList.size()-1);
                
                if(!flag){
                    break;
                }
            }
            return true;
        }
    }
}