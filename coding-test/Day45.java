import java.util.*;
class Day45 {
    class Solution {
        public int[] solution(int[] arr) {
            List<Integer> array = new ArrayList<>();
            for(int a : arr) {
                array.add(a);
            }
            Arrays.sort(arr);
            int min = arr[0];
            array.remove(Integer.valueOf(min));
            int[] answer = new int[array.size()];
            for(int i = 0; i<answer.length; i++) {
                answer[i]=array.get(i);
            }
            if(answer.length==0) {
                return new int[]{-1};
            } else {
                return answer;
            }
        }
    }
}