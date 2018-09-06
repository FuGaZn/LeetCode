/**
给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

说明：
	num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

*/

class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        StringBuilder res = new StringBuilder();
        int p = 0;
        for(int i=sb2.length()-1;i>=0;i--){
            StringBuilder tmp = multiplyChar(sb1, sb2.charAt(i));
            tmp = pow(tmp, p);
            res = add(res, tmp);
            p++;
        }
        
        return res.toString();
    }
    
    public static StringBuilder pow(StringBuilder num, int pow){
        for(int i=0;i<pow;i++){
            num.append("0");
        }
        return num;
    }
    
    public static StringBuilder multiplyChar(StringBuilder num, char c) {
        int a = 0;
        StringBuilder res = new StringBuilder();
        int n = c-'0';
        int b=0,d=0;
        for(int i = num.length()-1;i>=0;i--){
            b = num.charAt(i)-'0';
            d = b*n%10+a;
            
            res.insert(0,d%10);
            a = b*n/10+d/10;
        }
        if(a!=0){
            res.insert(0,a);
        }
        return res;
    }
    
    public static StringBuilder add(StringBuilder num1, StringBuilder num2){
        StringBuilder res = new StringBuilder("");
        while(num1.length()<num2.length()){
            num1.insert(0,0);
        }
        while(num2.length()<num1.length()){
            num2.insert(0,0);
        }
        int n = 0;
        for(int i=num1.length()-1;i>=0;i--){
            int a = num1.charAt(i)-'0'+num2.charAt(i)-'0'+n;
            int b = a%10;
            res.insert(0,b);
            n = a/10;
        }
        if(n!=0){
            res.insert(0,n);
        }
        int r = 0;
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)=='0'){
                r++;
            }else
                break;
        }
        if(r==res.length()) return (new StringBuilder("0"));
        
        res.delete(0,r);
        return res;
    }
    
}