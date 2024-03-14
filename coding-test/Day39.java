import java.util.*;
public class Day39 {
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] lists = new char[s.length()];
        List<Character> charList = new ArrayList<>();

        for(int i = 0; i<s.length(); i++) {
            charList.add(s.charAt(i));
        }
        Collections.sort(charList, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return c2.compareTo(c1);
            }
        });
        for(int i = 0; charList.size() > i; i++) {
            answer = answer + charList.get(i);
        }
        return answer;
    }
}
}
