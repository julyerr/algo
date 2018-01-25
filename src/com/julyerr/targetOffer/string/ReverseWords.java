package com.julyerr.targetOffer.string;

/**
 * 输入一个英文句子，翻转单词顺序，单词内字符不翻转，标点符号和普通字母一样处理。
 * 例如输入输入“I am a student.”，则输出“student. a am I”。
 */
public class ReverseWords {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strings = str.split(" ");
        if (strings.length == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = strings.length - 1;
//        通过设置一个flag，每进出一次单词的话更新一次
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                flag = true;
                stringBuilder.append(" ");
            } else {
                if (flag) {
                    stringBuilder.append(strings[index--]);
                }
                flag = false;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
//        System.out.println(reverseWords.ReverseSentence("I am a student."));
        System.out.println(reverseWords.ReverseSentence("  I  am a student. "));
        System.out.println(reverseWords.ReverseSentence(" "));
    }
}
