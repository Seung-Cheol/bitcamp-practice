public class Day22 {
  import java.util.*;

//솔루션 1번은 타임 초과
//스트링 빌더가 그냥 +로 문자열 더하는 것보다 빠르다
//toString을 통하여 스트링빌더로 빌드된 문자열을 다시 String 객체로 복구 가능하다
//아스키코드 48은 0이다. 그러므로 문자열 0을 char로 변환했을 때 48이 주어진다
//Collections.sort(arr, Collections.reverseOrder()); 내림차순으로 컬렉션 객체 반환
//Arrays.sort(arr)은 일반적인 오름차순 정렬
class Solution1 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/131128
    public String solution(String X, String Y) {
        String answer = "";
        List<String> arr = new ArrayList<>();
        Map<Character, Integer> countMapX = new HashMap<>();
        Map<Character, Integer> countMapY = new HashMap<>();

        for (int i = 0; X.length()>i; i++) {
            char temp = X.charAt(i);
            countMapX.put(temp, countMapX.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; Y.length()>i; i++) {
            char temp = Y.charAt(i);
            countMapY.put(temp, countMapY.getOrDefault(temp, 0) + 1);
        }
        
        for (char ch : countMapX.keySet()) {
            int occurrencesX = countMapX.get(ch);
            int occurrencesY = countMapY.getOrDefault(ch, 0);
            int commonOccurrences = Math.min(occurrencesX, occurrencesY);
            String temp = String.valueOf(ch);
           
            for (int i = 0; i < commonOccurrences; i++) {
                arr.add(temp);
            }
        }

        Collections.sort(arr, Collections.reverseOrder());

        for (String str : arr) {
            answer += str;
        }
        if(answer.length() > 1 && String.valueOf(answer.charAt(0)).equals("0")) {
            answer = "0";
        }
        if(answer.equals("")) {
            answer = "-1";
        }

        return answer;
    }
}


class Solution2 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<String> arr = new ArrayList<>();
        int[] listX = new int[10];
        int[] listY = new int[10];
        int xLeng = X.length();
        int yLeng = Y.length();
        for (int i = 0; xLeng>i; i++) {
            listX[X.charAt(i) - 48] += 1;
        }

        for (int i = 0; yLeng>i; i++) {
            listY[Y.charAt(i) - 48] += 1;
        }
        
        for (int i = 0; i<10; i++) {
            int occurrencesX = listX[i];
            int occurrencesY = listY[i];
            int commonOccurrences = Math.min(occurrencesX, occurrencesY);
            String temp = String.valueOf(i);
           
            for (int a = 0; a < commonOccurrences; a++) {
                arr.add(temp);
            }
        }

        Collections.sort(arr, Collections.reverseOrder());

        for (String str : arr) {
            answer.append(str);
        }
        if(answer.length() > 1 && (answer.toString().charAt(0)==48)) {
            return "0";
        }
        if("".equals(answer.toString())) {
            return "-1";
        }

        return answer.toString();
    }
}
}
