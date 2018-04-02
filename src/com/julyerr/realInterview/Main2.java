package com.julyerr.realInterview;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            String[] words = scanner.nextLine().split(" ");
            Set<String> wordsSet = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                wordsSet.add(words[i]);
            }
            String target = new StringBuilder(word).reverse().toString();
            System.out.println(bfs(word, target, wordsSet));
        }
    }

    private static int bfs(String word, String target, Set<String> wordsSet) {
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        Queue<String> tmp = new LinkedList<String>();
        Queue<Integer> depths = new LinkedList<Integer>();
        tmp.add(word);
        depths.add(1);

        char[] targetChars = target.toCharArray();
        Arrays.sort(targetChars);

        boolean first = true;
        while (!tmp.isEmpty()) {
            String cur = tmp.poll();
            char[] currentChars = cur.toCharArray();
            int currentLen = depths.poll();
            int diff = 0;

            Arrays.sort(currentChars);
            if(!first){
                for (int i = 0; i < word.length(); i++) {
                    if (currentChars[i] != targetChars[i]) {
                        diff++;
                    }
                    if (diff >= 2) {
                        break;
                    }
                }
                if (diff < 2) {
                    return 1 + currentLen;
                }
            }
            first = false;
            for (int i = 0; i < cur.length(); i++) {
                char mychar = currentChars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (mychar == j) continue;
                    currentChars[i] = j;
                    String nextString = new String(currentChars);
                    if (wordsSet.contains(nextString) && !visited.containsKey(nextString)) {
                        visited.put(nextString, true);
                        tmp.add(nextString);
                        depths.add(currentLen + 1);
                    }
                    currentChars[i] = mychar;
                }
            }
        }
        return 99;
    }
}
