/**
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

说明:
	被除数和除数均为 32 位有符号整数。
    除数不为 0。
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

*/

class Solution {
    public int divide(int dividend, int divisor) {
        long res=0;
        if(divisor==0)  return -1;
        int sign=1;
        if(dividend<0&&divisor>0 || dividend>0&&divisor<0){
            sign = -1;
        }
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        while(dvs<=dvd){
            long tmp = dvs, mul=1;
            while(dvd>=(tmp<<1)){
                tmp<<=1;
                mul<<=1;
            }
            dvd -= tmp;
            res+= mul;
        }
        res *= sign;
        if(res<-2147483648||res>2147483647){
            return 2147483647;
        }
        return (int)res;
    }
}