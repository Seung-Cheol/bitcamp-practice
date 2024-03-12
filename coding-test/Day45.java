import java.util.*;
class Day45 {
    class Solution {
        public int[] solution(int[] arr) {
            //값 복사
            int[] temp = arr;
            //새 배열 생성
            List<Integer> array = new ArrayList<>();
            Arrays.sort(arr);
            // 최소값 구하기
            int min = arr[0];
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == min) {
                    continue;
                }
                array.add(temp[i]);
            }

            int[] answer = new int[arr.length - 1];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = array.get(i);
            }
            return answer;
        }
    }
}