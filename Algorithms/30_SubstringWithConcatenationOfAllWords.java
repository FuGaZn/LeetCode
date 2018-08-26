/**
与所有单词相关联的字串：

给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1:

输入:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出: [0,9]
解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
*/

/**
思路：首先把字典里的单词放到HashMap中，其中Integer部分存储此单词在字典中出现的次数。
遍历字符串的每一个位置，如果是以字典中的某一个单词为前缀，那么继续检查前缀后面剩下的字符串，同时把字典中对应的出现次数减一。
当字典中单词出现次数为零的时候证明这个单词已经匹配完毕，那就从字典中删掉。
如果字典空了代表所有单词已经全都被匹配，证明这个位置起始的字符串是符合条件的，那么就把起始位置加入结果，之后继续迭代下一个位置。
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        if(s == null || s.length()==0 || words==null || words.length == 0){
            return res;
        }
        int size = words[0].length(), len = words.length;
        for(int i=0;i<=s.length()-len;i++){
            HashMap<String, Integer> m = new HashMap<>();
            for(int j=0;j<words.length;j++){
                m.put(words[j], m.getOrDefault(words[j], 0)+1);
            }
            if(this.check(s, i, m, size))
                res.add(i);
        }
        return res;
    }
    
    private boolean check(String s, int i, HashMap<String, Integer> m, int size){
        if(m.size()==0) return true;
        if(i>s.length()||i+size>s.length()) return false;
        
        String prefix = s.substring(i,i+size);
        if(m.containsKey(prefix) && m.get(prefix)>0) {
            m.put(prefix, m.get(prefix)-1);
            if(m.get(prefix) == 0)  m.remove(prefix);
            return this.check(s, i+size, m, size);
        }else
            return false;
    }
    
}