/**
	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
*/

/**
	解题思路：以中间的某个位置为中心，向左右两边扩展，判断对称的两个位置的字符是否相同。
	注意点：有些回文字符串是“abba”结构，因此不能以原字符串的某个字符为中心开始扩展，否则不能正确判断。
	正确做法：假设有一个新字符串，这个字符串的长度是2 * len-1，其由原字符串和字符之间的空字符组成。
*/

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s.length()==0||s.length()==1)    return s;
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1))    return s;
            else    return s.substring(0,1);
        }
        int len = 2*s.length()-1;
        for(int i = 1;i<len-1;i++){
            int j = 1;
            while(true){
                int l=0,r=0;
                if(i%2==0){
                    l=(i-j-1)/2;
                    r=(i+j+1)/2;
                }else{
                    l=(i-j)/2;
                    r=(i+j)/2;
                }
                if(l>=0&&r<s.length()){
                    if(s.charAt(l)==s.charAt(r)){
                        j+=2;
                    }else{
                        res = (res.length()<r-l-1)?s.substring(l+1,r):res; 
                        break;
                    }
                }else{
                    res = (res.length()<r-l-1)?s.substring(l+1,r):res;
                    break;
                }
            }
            
        }
        return res;
    }
}