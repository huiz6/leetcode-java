package org.example.no5;

public class LongestPalindromicSubstring3 {

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        char[] newC = new char[charArray.length * 2 + 1];
        newC[0] = '#';

        // c的指针
        int i = 0;
        // newC的指针
        int j = 1;

        // 使用辅助字符#处理原字符串
        while (i < charArray.length && j < newC.length - 1) {
            newC[j++] = charArray[i++];
            newC[j++] = '#';
        }

        return this.process(newC);
    }

    private String process(char[] charArray) {
        // 这里的R和定义中有些不同，这里是指i之前字符的回文区域最右边的下标的后一位，也就是说R-1才是回文区域最右边的下标
        int R = -1;
        // 中心
        int C = -1;

        // 回文半径数组
        int[] next = new int[charArray.length];

        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            // 先确定所有情况中最低回文半径
            // 如果i > R，表示第一种大情况，最低回文半径为自身为1
            // 如果 i < R，表示第二种大情况：
            // 如果是第①种小情况，i'的回文半径会比R-i小，直接可以确定为i'的回文半径
            // 如果是第②种小情况，i’的回文半径会比R-i大，直接可以确定为R-i
            // 如果是第③种小情况，i’的回文半径和R-i相等，虽然不能确定最终的回文半径，但是可以确定最少就是i'的回文半径或R-i
            next[i] = i < R ? Math.min(next[2 * C - i], R - i) : 1;

            // 无论是遇到哪一种情况都会尝试着往外扩，因为只有第一种大情况和第二种大情况的第③种小情况需要向外扩，因此如果是第二中大情况的
            // 第①种小情况或者第②种小情况虽然也会走向外扩的流程，但是第一次就会失败，从而跳出循环。
            // 这是为了省略多个if-else所做的一个统一的流程，优化了代码的长度，并不会影响时间复杂度
            while (i + next[i] < charArray.length && i - next[i] >= 0) {
                if (charArray[i + next[i]] == charArray[i - next[i]]) {
                    next[i]++;
                } else {
                    break;
                }
            }
            max = Integer.max(max, next[i]);

            // 判断R和C是否需要更新
            if (i + next[i] > R) {
                // R向右扩
                R = i + next[i];
                // 此时i就是当前所有字符的回文区域达到最右的区域的中心点
                C = i;
            }
        }

        String palindromeStr = "";
        for (int i = 0; i < charArray.length; i++) {
            if (next[i] == max) {
                palindromeStr = new String(charArray).substring(i - next[i] + 1, i + next[i]);
                break;
            }
        }

        return palindromeStr.replace("#", "");
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring3 longestPalindromicSubstring = new LongestPalindromicSubstring3();
        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaa"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

}
