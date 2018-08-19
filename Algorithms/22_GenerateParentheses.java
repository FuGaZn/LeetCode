/**
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList();
        if(n==0)    return ret;
        dfs(ret, "", 0, 0, n);
        return ret;
    }
    
    public void dfs(List<String> list,String tmp, int l, int r, int n){
        if(l>n||r>l)    return;
        if(l==n&&r==n){
            list.add(tmp);
        }
        dfs(list, tmp+"(", l+1, r, n);
        dfs(list, tmp+")", l, r+1, n);
    }
}