public class Day18 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12922
  class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i = 1; n>=i; i++) {
            if(i%2==0) {
                answer += "박";
            } else {
                answer += "수";
            }
        }
        return answer;
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/77884
class Solution2 {
  public int solution(int left, int right) {
      int answer = 0;
      for(int i=left; right>=i; i++) {     
          int cnt = 0;
          for(int a=1; i>=a; a++) {
              if(i%a==0) {
                  cnt++;
              }
          }
          if(cnt%2==0) {
              answer += i;
          } else {
              answer -= i;
          }
      }
      return answer;
  }
}

