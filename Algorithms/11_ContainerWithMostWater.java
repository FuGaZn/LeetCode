/**
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
*/

/**
如果采用暴力做法，双重循环，会导致TLE
使用left和right两个指针，每次替换掉height较小的那个指针，依次来遍历，取得最大值
*/
class Solution {
	public int maxArea(int[] height){
		int maxArea = 0;
		int left = 0, right = height.length-1;
		
		while(left<right){
			int w = right-left, height=0;
			if(height[right]>height[left]){
				h=height[left];
				left++;
			}else{
				h=height[right];
				right--;
			}
			maxArea = (maxArea>w*h)?maxArea:w*h;
		}
		return maxArea;
	}
}