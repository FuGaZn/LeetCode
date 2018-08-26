/**
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。
*/

/**
思路：

1. 数组从后向前遍历，找出第一个比前一个数还大的数，记下它的索引ind。

2. 在(ind, len-1]的索引范围中找到一个比此索引对应值略大的**最小值**。将该值和(ind-1)对应值交换

3. 对[ind, len-1]范围内的数进行从小到大排序。

注：将ind初始值设为0，这样。如果没找到比前一个数还大的数，说明不存在下一个更大的排列，此时排序后即得最小序列。

*/
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1)
            return;
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
    }
}