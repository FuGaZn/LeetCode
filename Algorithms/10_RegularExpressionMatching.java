/**
给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。

匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:

    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

*/

class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length() == 0;
        
        if(p.length() == 1){
            return s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        }
		
        //如果p的第二个字符不是*，那么就比较s和p的第一个字符是否相等。
		//如果相等，就比较各减去第一个字符的剩下字符串是否匹配
        if(p.charAt(1)!='*'){
            if(s.length()==0)
                return false;
            else
                return (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')
                        && isMatch(s.substring(1), p.substring(1));
        }else{
			//如果p的第二个字符是*，那么s就不断去掉首部相同的字符
            while(s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')){
                if(isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }
        }
        return isMatch(s, p.substring(2));
    }
}