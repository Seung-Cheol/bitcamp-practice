import java.util.*;
public class Day24 {
//https://school.programmers.co.kr/learn/courses/30/lessons/160586
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character,Integer> map = new HashMap<>();
        //맵으로 알파벳과 인덱스를 매칭하고
        for(String key : keymap) {
            for(int i=0; key.length()>i; i++) {
                if(!map.containsKey(key.charAt(i))) {
                    map.put(key.charAt(i), i+1);
                    continue;
                }
                if(map.get(key.charAt(i)) > i) {
                    map.put(key.charAt(i), i+1);
                }
            }
        }
        //타겟을 계산한다
        for(int i = 0; i<targets.length; i++) {
            for(int a = 0; a<targets[i].length(); a++) {
                if(!map.containsKey(targets[i].charAt(a))) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(targets[i].charAt(a));
            }
        }
        
        return answer;
    }
}
}
