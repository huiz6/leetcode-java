package org.example.no126;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visitedWordSet = new HashSet<>();
        Deque<List<String>> deque = new ArrayDeque<List<String>>() {{
            add(new ArrayList<String>() {{
                    add(beginWord);
                }}
            );
        }};
        while (!deque.isEmpty()) {
            Set<String> currentVisitedWordSet = new HashSet<>();
            int dequeSize = deque.size();
            for (int j = 0; j < dequeSize; j++) {
                List<String> currentList = deque.pop();
                String lastWord = currentList.get(currentList.size() - 1);
                if (lastWord.equals(endWord)) {
                    resList.add(currentList);
                    continue;
                }

                for (int i = 0; i < lastWord.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String replaceWord = lastWord.substring(0, i) + c + lastWord.substring(i + 1);
                        if (wordSet.contains(replaceWord) && !visitedWordSet.contains(replaceWord)) {
                            List<String> nextList = new ArrayList<>(currentList);
                            nextList.add(replaceWord);
                            deque.addLast(nextList);
                            currentVisitedWordSet.add(replaceWord);
                        }
                    }
                }
            }
            visitedWordSet.addAll(currentVisitedWordSet);

        }
        return resList;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        List<List<String>> ladderList = new WordLadderII().findLadders(beginWord, endWord, wordList);
        for (List<String> ladder : ladderList) {
            System.out.println(ladder.toString());
        }
    }

}
