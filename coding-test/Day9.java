import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/135808
public class Day9 {

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int answer = 0;
        Arrays.sort(score);
        //stream객체에 score삽입
        //boxed  : int를 integer로 감싸기
        //sort(Collections.reverseOrder()) collentions 객체를 이용하여 내림차순으로 정렬
        //integer로 전환
        //array로 전환
        score = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int box = score.length/m;
        
        for(int i=1; i<=box; i++) {
            answer += score[i*m-1] * m;
        }
        return answer;
    }
}
}
