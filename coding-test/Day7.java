public class Day7 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/140108

  //내 풀이
  //밖에 변수를 둬서 끊어질때마다 answer에 1 추가
  //2번 끊어지면 3개의 단어가 나오므로 answer 초기값 1 추가
  class Solution {
    public int solution(String s) {
        int answer = 1;
        //
        int i = 1;
        int temp = 1;
        char temp2 = s.charAt(0);
            while(i<s.length()) {
            if(temp==0) {
                temp++;
                temp2 = s.charAt(i);
                answer++;
            } else {
                temp = s.charAt(i)==temp2 ? temp++ : temp--
            }           
            i++;
            }
        return answer;
    }
}
  
}
