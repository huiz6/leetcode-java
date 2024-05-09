package org.example.no49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] keyArray = new int[26];
            for (char c : str.toCharArray()) {
                keyArray[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (keyArray[i] > 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(keyArray[i]);
                }
            }
            String key = sb.toString();

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<String>() {{
                    add(str);
                }});
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        System.out.println(groupAnagrams.groupAnagrams(strs1));
    }

}
