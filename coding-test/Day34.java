import java.util.*;
public class Day34 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/1845
  class Solution {
      public int solution(int[] nums) {
          int answer = 0;
          int count = nums.length/2;
          Set<Integer> iset = new HashSet<>();
          for(int num : nums) {
              iset.add(num);
          }
          if(iset.size() > count) {
              answer = count;
          } else {
              answer = iset.size();
          }
          return answer;
      }
  }
}
