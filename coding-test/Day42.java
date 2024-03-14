public class Day42 {
  //내가 기존에 푼 틀린문제
  //https://school.programmers.co.kr/learn/courses/30/lessons/12945
  //long 값 조차 담을 수 없는 큰 숫자가 올 경우 에러 발생
  class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] list = new long[n+1];
        list[0] = 0;
        list[1] = 1;
        for(int i = 2; i<=n; i++) {
            list[i] = list[i-1] + list[i-2];
        }
        answer = (int)(list[n] % 1234567);
        return answer;
      }
  }

class Solution {
  public int solution(int n) {
      int answer = 0;
      int[] list = new int[n+1];
      list[0] = 0;
      list[1] = 1;
      for(int i = 2; i<=n; i++) {
          list[i] = (list[i-1] + list[i-2]) % 1234567;
      }
      answer = list[n];
      return answer;
  }
}
}
