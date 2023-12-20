
public class Day13 {
  class Solution {
    //https://school.programmers.co.kr/learn/courses/30/lessons/12928
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(n%i==0) {
                answer += i;
            }
        } 
        return answer;
    }
}

class Solution2 {
  public int solution(String s) {
    //https://school.programmers.co.kr/learn/courses/30/lessons/12925?language=java
      int answer = 0;
      if(s.charAt(0)==('-')){
          answer -= Integer.parseInt(s.substring(1));
      } else if (s.charAt(0)==('+')) {
          answer += Integer.parseInt(s.substring(1));
      } else {
          answer += Integer.parseInt(s);
      }
      return answer;
      
  }
}
//https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=java
class Solution3 {
  public long[] solution(int x, int n) {
      long[] answer = new long[n];
      answer[0] = x;
      for(int i = 1; i<n; i++) {
          answer[i] = answer[i-1] + x;
      }
      return answer;
  }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/87389
class Solution4 {
  public int solution(int n) {
      int answer = 0;
      for(int i=1; i<=n; i++) {
          if(n%i==1) {
              answer = i;
              break;
          }
      }
      return answer;
  }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/12916
class Solution5 {
  boolean solution(String s) {
      boolean answer = true;
      int a = 0;
      // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
      System.out.println("Hello Java");
      for(int i = 0; i<s.length(); i++) {
          if(s.charAt(i) == 'y' || s.charAt(i) == 'Y' ) {
              a++;
          }
          
          if(s.charAt(i) == 'p' || s.charAt(i) == 'P' ) {
              a--;
          }
      }
      if(a!=0)
          answer = false;

      return answer;
  }
}
//https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java
class Solution6 {
  public int[] solution(long n) {
      String temp = String.valueOf(n);
      int length = temp.length();
      int[] answer = new int[length];
      for(int i = length; i>0; i--) {
          answer[length-i] = temp.charAt(i-1) - 48;
      }
          
      return answer;
  }
}


  
}
