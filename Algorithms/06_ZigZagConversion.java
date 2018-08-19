/**
	将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
	P   A   H   N
	A P L S I I G
	Y   I   R
	之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
	实现一个将字符串进行指定行数变换的函数
*/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||numRows==0)  return s;
        char[][] zigNums = new char[s.length()][numRows];
        boolean[][] isNull = new boolean[s.length()][numRows];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<numRows;j++){
                isNull[i][j]=true;
            }
        }
        int m=0,n=0;
        boolean b=false;
        for(int i=0;i<s.length();i++){
            zigNums[m][n]=s.charAt(i);
            isNull[m][n]=false;
            if(b==false){
                n++;
            }else{
                n--;
                m++; 
                if(n==0){
                    b=false;
                }
                if(n==-1){
                    n=1;
                    b=false;
                }
            }
            if(n==numRows){
                b=true;
                m++;
                n-=2;
            }
        }
        StringBuilder res = new StringBuilder();
        
        for(int j=0;j<numRows;j++){
            for(int i=0;i<s.length();i++){
                if(isNull[i][j]==false){
                    res.append(zigNums[i][j]);
                }
            }
        }
        return res.toString();
    }
}