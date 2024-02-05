package org.example.no763;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        Map<String, Integer> alphabetStartIndexMap = new HashMap<>();
        Map<String, Integer> alphabetEndIndexMap = new HashMap<>();
        List<String> alphabetList = new ArrayList<>();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            String startAlphabet = s.substring(i, i + 1);
            String endAlphabet = s.substring(sLength - i - 1, sLength - i);
            if (!alphabetStartIndexMap.containsKey(startAlphabet)) {
                alphabetStartIndexMap.put(startAlphabet, i);
                alphabetList.add(startAlphabet);
            }
            if (!alphabetEndIndexMap.containsKey(endAlphabet)) {
                alphabetEndIndexMap.put(endAlphabet, sLength - i - 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        int start = alphabetStartIndexMap.get(alphabetList.get(0));
        int end = alphabetEndIndexMap.get(alphabetList.get(0));
        for (int i = 1; i < alphabetList.size(); i++) {
            String alphabet = alphabetList.get(i);
            if (alphabetStartIndexMap.get(alphabet) < end && alphabetEndIndexMap.get(alphabet) > end) {
                end = alphabetEndIndexMap.get(alphabet);
            } else if (alphabetStartIndexMap.get(alphabet) < end && alphabetEndIndexMap.get(alphabet) < end) {
                continue;
            } else {
                resultList.add(end - start + 1);
                start = alphabetStartIndexMap.get(alphabet);
                end = alphabetEndIndexMap.get(alphabet);
            }
        }
        resultList.add(end - start + 1);
        return resultList;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        List<Integer> resultList = new PartitionLabels().partitionLabels(s);
        System.out.println(resultList.toString());
    }

}
