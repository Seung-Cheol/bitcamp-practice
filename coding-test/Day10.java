public class Day10 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/134240
  class Solution {
    public String solution(int[] food) {
        String answer = "";
        String temp = "";
        for(int i = 1; i<food.length; i++) {
            if(food[i]<=1)
                continue;
                //repeat 메서드는 문자열에 직접 입력
            String tempString = String.valueOf(i).repeat(food[i]/2);
            answer += tempString;
            temp += tempString;
        }
        //스트링버퍼 클래스 활용, 인스턴스 변수에서 reverse 활용
        StringBuffer sb = new StringBuffer(temp);
        answer = answer + "0" + sb.reverse();
        return answer;
    }
}
  
}
