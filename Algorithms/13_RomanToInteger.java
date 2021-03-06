/**
罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
*/

class Solution {
    public int romanToInt(String s) {
        int[] vals = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] strs = new String[]
            {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int res = 0;
        int ind = strs.length-1,j=0;
        while(j<s.length()){
            String s1 = s.substring(j,j+1);
            String s2 = "";
            if(j+2<=s.length()){
                s2 = s.substring(j,j+2);
            }
            for(int i = ind;i>=0;i--){
                int val1 = 0,val2=0;
                if(s1.equals(strs[i])||s1==strs[i]){
                    val1 = vals[i];
                }
                if(s2.equals(strs[i])||s2==strs[i]){
                    val2 = vals[i];
                }
                if(val2!=0){
                    res+=val2;
                    j+=2;
                    break;
                }else if(val1!=0){
                    res+=val1;
                    j++;
                    break;
                }
            }
        }
        return res;
    }
}
