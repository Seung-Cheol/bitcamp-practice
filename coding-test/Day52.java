public class Day52 {
//https://school.programmers.co.kr/learn/courses/30/lessons/12924
  class Solution1 {
    public int solution(int n) {
        int answer = 0;
        int x = n;
        for(int i = 1; i<=n; i++) {
            for(int a = i; a<=n; a++) {
                x = x-a;
                if(x==0) {
                    answer++;
                    break;
                }
                if(x<0) {
                    break;
                }
            }
            x = n;
        }
        
        return answer;
    }
}


  
}
