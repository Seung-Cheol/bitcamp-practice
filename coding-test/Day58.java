import java.util.*;
public class Day58 {
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();

        //i는 1부터 원판을 돈다 합해서 5번을 돈다
        for (int i = 1; i <= elements.length; i++) {
            //j는 원판 시작위치부터 배열
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                //원판 시작위치부터 길이 위치까지 더하기 처음은 1+0; 0 ;
                for (int k = j; k < j + i; k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
  
}
