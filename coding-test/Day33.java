import java.util.*;
public class Day33 {
class Solution1 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/68644
    public int[] solution(int[] numbers) {
        Set<Integer> iset = new HashSet<>();
        for(int i = 0; numbers.length>i; i++) {
            for(int a=0; numbers.length>a; a++) {
                if(i!=a) {
                    iset.add(numbers[i] + numbers[a]);
                }
            }
        }
        int[] answer = new int[iset.size()];
        Iterator iter = iset.iterator();
        int c = 0;
        while(iter.hasNext()) {
            answer[c] = (int)iter.next();
            c++;
        }
        Arrays.sort(answer);
        return answer;
    }
}

class Solution2 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/17681
  public String[] solution(int n, int[] arr1, int[] arr2) {
    //정답 세로줄 생성
      String[] answer = new String[n];       
      for(int i = 0; i < n; i++) {
        //Integer 클래스에 toBinaryString이 있고 이것은 2진수 그대로 스트링 변경
          String bi = Integer.toBinaryString(arr1[i] | arr2[i]);
        // 앞자리가 비어있으면 0으로 채워주기 위함
          bi = "0".repeat(n - bi.length()) + bi;
        //replaceAll을 통하여 #과 공백으로 변경
          answer[i] = bi.replaceAll("1", "#").replaceAll("0", " ");
      }
      return answer;
  }
}

class Solution3 {

  //https://school.programmers.co.kr/learn/courses/30/lessons/132267
  public int solution(int a, int b, int n) {
      int answer = 0;
      
      while(n>=a) {
          answer += b*(n/a);
          n = b*(n/a) + n%a;
      }
      return answer;
  }
  
  
}

}
