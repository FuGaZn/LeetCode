/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串
*/

/**
用一个栈来存储左括号，每次遇到右括号就出栈一个字符，如果不是匹配的左括号，就返回false。
如果最后栈内还有字符，说明存在左括号无匹配，返回false
*/

class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()==0)  return true;
        
        char[] lchar = new char[]{'(','[','{'};
        char[] rchar = new char[]{')',']','}'};
        boolean b = true;
        Stack<Integer> lstack = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j=0;j<lchar.length;j++){
                if(c==lchar[j]){
                    lstack.push((int)(c-'0'));
                    break;
                }
            }
            for(int j=0;j<rchar.length;j++){
                if(c==rchar[j]){
                    if(!lstack.empty()){
                        int a = lstack.pop();
                        if(a!=lchar[j]-'0'){
                            return false;
                        }else{
                            break;
                        }
                    }else{
                        return false;
                    }
                    
                }
            }
        }
        if(!lstack.empty()){
            return false;
        }
        return b;
    }
}