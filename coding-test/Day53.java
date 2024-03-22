import java.util.*;

public class Day53 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42885
  class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //오름차순으로 정렬
        Arrays.sort(people);
        int left = 0;
        //맨 마지막 정렬
        int right = people.length - 1;
        
        //right 숫자를 줄여나가면서
        while (left <= right) {
            //만약 무게가 ㄱㅊ으면 왼쪽 포인터 이동
            //가장 무거운것과 가벼운것이 합쳐진다면 소모했으므로 그다음으로 이동
            if (people[left] + people[right] <= limit) {
                left++;
            }
            //합쳐지지 않으면 1인용이므로 오른쪽 포인트 이동
            right--;
            answer++;
        }
        return answer;
    }
}
}
