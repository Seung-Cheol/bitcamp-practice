import java.util.*;
class Day49 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/12941
    class Solution
    {
        public int solution(int[] A, int[] B)
        {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);

            for(int i= 0; i<A.length; i++) {
                answer += A[i] * B[B.length-1-i];
            }

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }
}