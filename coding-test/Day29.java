import java.util.*;
public class Day29 {
//https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Solution {
    public int[] solution(int []arr) {
        
        int temp = -1;
        int index = 0;
        List<Integer> tlist = new ArrayList<>();
        for(int ar : arr) {
            if(temp==ar) {
                temp = ar;
                continue;
            }
            tlist.add(ar);
            temp = ar;
        }
        int[] answer = new int[tlist.size()];
        for(int i = 0; tlist.size()>i; i++) {
            answer[i] = tlist.get(i);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
}
