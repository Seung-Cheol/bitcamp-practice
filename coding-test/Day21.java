public class Day21 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/77484#
  class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7,7};
        boolean flag = false;
        for(int i = 0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                answer[0] -=1;
                continue;
            }
            for(int a = 0; a<win_nums.length; a++) {
                if(lottos[i] == win_nums[a]) {
                    answer[1] -=1;
                    answer[0] -=1;
                    break;
                }
            }
        }
        if(answer[1]>=6) {
            answer[1] = 6;
        }
         if(answer[0]>=6) {
            answer[0] = 6;
        }
        return answer;
    }
}
}
