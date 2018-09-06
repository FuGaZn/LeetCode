/**
给定 n 个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
*/

/**
思路：首先求出最大值的索引，设为i1，然后向左遍历，求出左边范围内的最大值，记索引为i2，
以i2和i1对应值之间为容器，雨水可以存储在此中，多余的雨水会流向左右的下方。
记容积为height[i2] * (i1-i2)，减去中间凸出的值，即为雨水的量。
然后记i1=i2，再继续向左遍历。直到i1=0为止。

同理可以向右遍历。
*/
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length;
        
        if(height == null || height.length==0||height.length==1)    return res;
        
        int i1 = max(height, 0, right);
        
        while(i1>0){
            int i2 = max(height, 0, i1);
            int a = height[i1], b = height[i2];
            int tmp = b*(i1-i2);
            for(int j = i2;j<i1;j++){
                tmp -= height[j];
            }
            res += tmp;
            i1 = i2;
        }
        
        i1 = max(height, 0, right);
        while(i1<height.length-1){
            int i2 = max(height, i1+1, right);
            int a = height[i1], b = height[i2];
            int tmp = b*(i2-i1);
            for(int j = i2;j>i1;j--){
                tmp -= height[j];
            }
            res+=tmp;
            i1 = i2;
        }
        return res;
    }
    
    public static int max(int[] nums, int l, int r){
        int tmp = nums[l];
        int res = l;
        for(int i=l;i<r;i++){
            if(nums[i]>tmp){
                tmp = nums[i];
                res = i;
            }
        }
        return res;
    }
}