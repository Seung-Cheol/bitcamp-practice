
public class Day12 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/159994
  class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int one = 0;
        int two = 0;
        String answer = "Yes";
        for(int i=0; i<goal.length; i++) {
          //왼쪽이 false라면 오른쪽이 실행되지 않기 때문에 에러 방지 가능
            if((cards1.length != one) && (cards1[one].equals(goal[i]))) {
                one++;
                continue;
            }
            if((cards2.length != two) && (cards2[two].equals(goal[i]))) {
                two++;
                continue;
            }
            answer="No";
        }
        
        return answer;
    }
}
}
