public class Day41 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12911
  class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        String str = Integer.toBinaryString(n);
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == '1') {
                cnt++;
            }
        }
        
        for(int i=n+1; i<1100000; i++) {
            int cnt2 = 0;
            String str2 = Integer.toBinaryString(i);
            for(int k = 0; k<str2.length(); k++) {
                if(str2.charAt(k) == '1') {
                    cnt2++;
                }
            }
            
            if(cnt==cnt2) {
                answer = i;
                break;
            }
            
        }
        return answer;
    }
}
}
