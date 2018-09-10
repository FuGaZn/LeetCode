/**
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] isIn = new boolean[strs.length]; //用来判断字符串是否已经被添加过了
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(isIn[i]==false){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                isIn[i]=true;
                for(int j=i+1;j<strs.length;j++){
                    if(isIn[j]==false){
                        if(isAnagrams(strs[i], strs[j])){
                            list.add(strs[j]);
                            isIn[j]=true;
                        }
                    }
                }
                res.add(list);
            }
        }
        return res;
    }
	
	/**
	*判断两个字符串是否是异位词
	*/
    public static boolean isAnagrams(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        if(s1.equals(s2)){
            return true;
        }
        int[] nums = new int[26];
        
        for(int i =0;i<s1.length();i++){
            nums[s1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s2.length();i++){
            nums[s2.charAt(i)-'a']--;
            if(nums[s2.charAt(i)-'a']<0){
                return false;
            }
        }
        
        return true;
    }
}