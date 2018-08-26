/**
最长有效括号

给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
*/

/**
思路：

新建两个栈，这两个栈的作用是记录字符串里所有没有相对括号可以匹配的括号的索引值。

具体做法：遍历字符串，遇到左括号，左括号入栈 ；遇到右括号，如果左括号栈不为空，则左括号出栈，否则右括号入右括号栈。

新建一个数组，数组长度等于两个栈的大小之和再加上2。

数组记录下栈里保存的索引，还要记录下起始位置（索引值为-1）和终止位置（索引值为s.length()）

对索引进行排序，依次相减，求出最大的中间值，即为最长有效括号。
*/
class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0)    return 0;
        int b=0,e=s.length();
    
        
        Stack<Integer> lstack = new Stack<Integer>();
        Stack<Integer> rstack = new Stack<Integer>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                lstack.push(i);
            }else{
                if(!lstack.empty()){
                    lstack.pop();
                }else{
                    rstack.push(i);
                }
            }
        }
		
		int res = 0;
		
        if(lstack.empty()&&rstack.empty()){
            return s.length();
        }else{
            int n = lstack.size()+rstack.size()+2;
            int[] arr = new int[n];
            arr[0]=-1;
            arr[1]=s.length();
            int i=2;
            while(!lstack.empty() || !rstack.empty()){
                if(!lstack.empty()){
                    arr[i] = lstack.pop();
                    i++;
                }
                if(!rstack.empty()){
                    arr[i] = rstack.pop();
                    i++;
                }
            }
            Arrays.sort(arr);
            for(int j=n-1;j>=1;j--){
                int tmp = arr[j]-arr[j-1]-1;
                res = (res>tmp)?res:tmp;
            }
        }
        return res;
    }
}