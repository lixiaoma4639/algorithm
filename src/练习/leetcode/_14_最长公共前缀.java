package 练习.leetcode;

/**
 * 日期 : 2021/5/24.
 * 创建 : xin.li
 * 描述 :
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
class _14_最长公共前缀 {
    public static void main(String[] args) {
        String s = longestCommonPrefix3(new String[]{"flower","flow","flight"});
        System.out.println(s);
    }

    /**
     * strs = ["flower","flow","flight"]
     * flower
     * flow
     * flight
     *
     * strs = ["dog","racecar","car"]
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String firstStr = strs[0];
        int firstLength = firstStr.length();
        int length = strs.length;
        for (int i = 0; i < firstLength; i++) {
            char fChar = firstStr.charAt(i);
            for (int j = 1; j < length; j++) {
                if (i == strs[j].length() || fChar != strs[j].charAt(i)){
                    return firstStr.substring(0 , i);
                }
            }
        }
        return strs[0];
    }


    /**
     * strs = ["flower","flow","flight"]
     * strs = ["dog","racecar","car"]
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            temp = getPrevCommon(temp , strs[i]);
        }
        return temp;
    }
    public static String getPrevCommon(String first , String second){
        int minSize = Math.min(first.length() , second.length());
        int index = 0;
        while (index < minSize && first.charAt(index) == second.charAt(index)){
            index++;
        }
        return first.substring(0 , index);
    }








    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
