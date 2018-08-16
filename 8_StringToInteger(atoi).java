/**
实现 atoi，将字符串转为整数。

在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。

当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。

若函数不能执行有效的转换，返回 0。

说明：
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
*/

/**
几个注意点：
* 不能用long来存储数字，因为所给字符串可能很长
* 注意前缀为一连串零的情况

*/
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length()==0) return 0;
        if(str.length()==1){
            if(str.charAt(0)<='9'&&str.charAt(0)>='0')  return (str.charAt(0)-'0');
            else return 0;
        }
        if(str.charAt(0)=='-'||str.charAt(0)=='+'||str.charAt(0)<='9'&&str.charAt(0)>='0'){
            int sign = 0;
            if(str.charAt(0)=='-'){
                int j=1;
                String res = "";
                while(j<str.length()){
                    if(str.charAt(j)<='9'&&str.charAt(j)>='0'){
                        res += str.charAt(j)-'0';
                        j++;
                    }else{
                        break;
                    }
                }
                int m=0;
                for(int i=0;i<res.length();i++){
                    if(res.charAt(i)=='0'){
                        m++;
                    }else   break;
                }
                res = res.substring(m,res.length());
                res = "-"+res;
                if(res.length()==1){
                    return 0;
                }else if(res.length()>11){
                    return -2147483648;
                }else{
                    if(Long.parseLong(res)<-2147483648) return -2147483648;
                    else return Integer.parseInt(res);
                }
            }else{
                int j=0;
                if(str.charAt(0)=='+'){
                    j=1;
                }
                String res = "";
                while(j<str.length()){
                    if(str.charAt(j)<='9'&&str.charAt(j)>='0'){
                        res += str.charAt(j)-'0';
                        j++;
                    }else{
                       break;
                    }
                }
                int m=0;
                for(int i=0;i<res.length();i++){
                    if(res.charAt(i)=='0'){
                        m++;
                    }else   break;
                }
                res = res.substring(m,res.length());
                if(res.length()==0){
                    return 0;
                }else if(res.length()>10){
                    return 2147483647;
                }else{
                    if(Long.parseLong(res)>2147483647) return 2147483647;
                    else return Integer.parseInt(res);
                }
            }    
        }else{
            return 0;
        }
    }
}