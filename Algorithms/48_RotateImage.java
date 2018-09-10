/**
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
*/

/**
先转置矩阵，再把每一行翻转
https://www.cnblogs.com/grandyang/p/4389572.html
*/

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix.length==1){
            return;
        }
        int len = matrix.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int tmp = matrix[i][j];
                //System.out.println(tmp);
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i=0;i<len;i++){
            int j = 0;
            while(j<len-j-1){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = tmp;
                j++;
            }
        }
        
    }
}