//https://school.programmers.co.kr/learn/courses/30/lessons/136798#

class Solution {
  public int solution(int number, int limit, int power) {
      int answer = 0;
      int tempNum = number+1;
      int[] count = new int[1000000];
      // 약수를 구할 때 배수를 이용하여 구하기
      // 배수를 배열에 넣고 2*4 시 2에서 카운트 1 4*2에서 카운트 1이므로 배수 2개
      for(int i=1; i<tempNum; i++) {
          for(int a=1; a<tempNum; a++) {
              if((long) a*i <= number)
                  count[a*i]++;
          }
      }
      
      for(int i=1; i<tempNum; i++) {
          if(count[i] <= limit) {
              answer += count[i];
          }
          
          if(count[i] > limit) {
              answer += power;
          }
      }
      
      
      return answer;
  }
}