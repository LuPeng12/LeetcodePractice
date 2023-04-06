package com.lu.practice.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lup
 * @create 2022/12/5 15:26
 * 给出由小写字母组成的字符串，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 */
public class 删除字符串中的所有相邻重复项_1047 {
    public static String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!deque.isEmpty() && deque.peek().equals(chars[i])){
                deque.pop();
            }else {
                deque.push(chars[i]);
            }
        }
      String s1 = deque.stream().map(Objects::toString).collect(Collectors.joining());
        return new StringBuilder(s1).reverse().toString();
    }

    //拿字符串直接作为栈，省去了栈还要转为字符串的操作。
    public String removeDuplicates2(String s) {
        // 将 res 当做栈
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
