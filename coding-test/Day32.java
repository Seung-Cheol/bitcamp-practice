import java.util.*;
public class Day32 {

//https://school.programmers.co.kr/learn/courses/30/lessons/42748
class Solution1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerCount = 0;
        for(int[] command : commands) {
            int length = command[1] - command[0] + 1;
            int[] temp = new int[length];
            int count = 0;
            for(int i = command[0] -1; i<command[1]; i++ ) {
                temp[count++] = array[i];
            }
            Arrays.sort(temp);
            count = 0;
            answer[answerCount++] = temp[command[2] -1];
        }
        return answer;
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/12915
class Solution2 {
  public String[] solution(String[] strings, int n) {
      Arrays.sort(strings, new Comparator<String>() {
          
          public int compare(String s1, String s2) {
              char c1 = s1.charAt(n);
              char c2 = s2.charAt(n);
              
              //첫번째가 더 크면 양수이기때문에 뒤로감 sort 실행
              if(c1==c2) {
                  return s1.compareTo(s2);
              } else {
                  return c1 - c2;
              }
          }
          
      });
      
      return strings;
  }
}
}
