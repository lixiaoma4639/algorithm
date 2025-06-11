package 练习.leetcode.字符串;

/**
 * 日期 : 2022/1/30.
 * 创建 : xin.li
 * 描述 :  https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 *
 * 输入：s = " a good   example"
 * 输出："example good a"
 *
 * 规律,  字符串翻转, 多使用char数组+快慢指针
 */
class _151_翻转字符串里的单词 {
    public static void main(String[] args) {
        _151_翻转字符串里的单词 sss = new _151_翻转字符串里的单词();
        String aaa = "  Bob    Loves  Alice   ";
        System.out.println("<"+sss.reverseWords(aaa)+">");

        String bbb = " a good   example";
        System.out.println("<"+sss.reverseWords(bbb)+">");
    }

    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int current = 0;
        boolean isSpace = true;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == ' '){
                if (!isSpace){
                    words[current] = words[i];
                    current++;
                }
                isSpace = true;
            } else {
                words[current] = words[i];
                current++;
                isSpace = false;
            }
        }
        int length = isSpace ? current - 1 : current;

        //整体翻转
        convert(words, 0, length-1);

        current = -1;
        for (int i = 0; i < length; i++) {
            if (words[i] != ' ') continue;
            convert(words, current + 1, i-1);
            current = i;
        }
        convert(words, current+1, length-1);

        return new String(words, 0, length);
    }

    private void convert(char[] words, int start, int end){
        while (start < end){
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }
}
