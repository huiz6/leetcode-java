package org.example.no383;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            counts[ransomNote.charAt(i) - 'a']--;
            if (counts[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        String ransomNoteStr = "a";
        String magazine = "b";
        System.out.println(ransomNote.canConstruct(ransomNoteStr, magazine));
    }
}
