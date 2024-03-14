public class Day35 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12977
  class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i<nums.length; i++) {
            for(int x = i+1; x<nums.length; x++) {
                for(int y= x+1; y<nums.length; y++) {
                    int sum = nums[i] + nums[y] + nums[x];
                    for(int k = 2; k<sum/2; k++) {
                        if(sum%k==0) {
                            break;
                        }
                        if(k==sum/2-1) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
}
