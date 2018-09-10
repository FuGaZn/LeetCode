/**
给定一个没有重复数字的序列，返回其所有可能的全排列
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        if(nums==null||nums.length==0){
            return new ArrayList();
        }
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        res.add(list);
        
        list = nextPermutation(nums);
        
        while(list.size()!=0){
            res.add(list);
            list = nextPermutation(nums);
        }
        return res;
    }
    
    
    
    public static List<Integer> nextPermutation(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1)
            return new ArrayList<>();
        int ind=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                ind = i;
                break;
            }
        }
        if(ind!=0){
            int val = nums[ind], ind2 = ind;
            for(int i = ind+1;i<nums.length;i++){
                if(nums[i]>nums[ind-1]&&nums[i]<val){
                    if(val>nums[i]){
                        val = nums[i];
                        ind2 = i;
                    }
                }
            }
            int tmp = val;
            nums[ind2] = nums[ind-1];
            nums[ind-1] = tmp;
        }else{
            return new ArrayList<>();
        }
        
        for(int i=ind;i<nums.length;i++){
            for(int j=ind;j<nums.length;j++){
                if(nums[i]>nums[j] && i<j){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }
        return res;
    }
}