import java.util.*;
public class Day28 {
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //참가자의 이름, 동명이인의 수 둘다 세팅해놓고
        //만약에 일치하지 않는 부분이 있다면 그사람이 정답임
        Map<String,Integer> map1 = new HashMap<>();
        //완주자 이름과 이름의 숫자를 맵에 저장
        for(int i = 0; participant.length>i; i++) {
            map1.put(participant[i], (map1.getOrDefault(participant[i],0) + 1));
        }
        for(int i = 0; completion.length>i; i++) {
            map1.put(completion[i], (map1.get(completion[i]) -1));
        }
        
        for(int i = 0; participant.length>i; i++) {
            if(map1.get(participant[i]) ==1) {
                answer += participant[i];
                break;
            }
        }
        return answer;
    }
}
}
