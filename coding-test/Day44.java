public class Day44 {
//https://school.programmers.co.kr/learn/courses/30/lessons/42842
  class Solution {
    public int[] solution(int brown, int yellow) {
      
        int[] answer = new int[2];
        int total = yellow + brown;
        for(int i = 1; i <=yellow; i++) {
                if(yellow%i == 0) {
                    if((i+2)*(yellow/i+2) == total) {
                        answer[1] = yellow/i+2;
                        answer[0] = i+2;
                    }
                }
        }
        return answer;//
    }
}
  
}
