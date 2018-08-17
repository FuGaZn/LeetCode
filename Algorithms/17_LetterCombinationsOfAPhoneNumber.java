/**
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList();
        if(digits==null||digits.length()==0){
            return ret;
        }
        char c1 = 'z'+1;
        char[] mark = new char[]{'a','d','g','j','m','p','t','w',c1};
        
        int m = digits.charAt(0)-'0'-2;
        char c2 = mark[m];
        while(c2!=mark[m+1]){
            ret.add(""+c2);
            c2++;
        }
        for(int i=1;i<digits.length();i++){
            int ind = digits.charAt(i)-'0'-2;
            char c = mark[ind];
            List list = new ArrayList();
            for(int j=0;j<ret.size();j++){
                char c3 = c;
                while(c3!=mark[ind+1]){
                    list.add(ret.get(j)+c3);
                    c3++;
                }
            }
            ret = list;
        }
        return ret;
    }
}
