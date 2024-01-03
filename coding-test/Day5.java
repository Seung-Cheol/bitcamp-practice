public class Day5 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        //오늘 날짜의 모든 일수
        int date = getDate(today);

        //약관 종류, 유효기간
        for (String s : terms) {
            String[] term = s.split(" ");
            //쪼갠 약관종류와 유효기간
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        //개인정보 수집날짜와 약관 종류
        for (int i = 0; i < privacies.length; i++) {

            //스플릿
            String[] privacy = privacies[i].split(" ");
            
            //오늘 날짜와 비교
            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
               //유효기간 배열
                answer.add(i + 1);
            }
        }
        //integer를 int로 변환
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
  
}
