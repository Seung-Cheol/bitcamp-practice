public class Day36 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12921
  //에라토스테네스의 체
  class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] nlist = new int[n+1];
        
        for(int i = 2; i<=n; i++) {
            nlist[i] = i;
        }
        
        for(int i = 2; i<=n; i++) {
            if(nlist[i]==0) continue;
            
            for(int k = i*2; k<=n; k+=i) {
                nlist[k] = 0;
            }
        }
        
        for(int i = 0; i<nlist.length; i++) {
            if(nlist[i]!=0) answer++;
        }
        return answer;
    }
}



import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/161989
class Solution2 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int maxFilter = 0;
        for(int i =0; section.length>i; i++) {
            if(maxFilter >= section[i]) continue;
            
            if(maxFilter < section[section.length-1]) {
                answer++;
                maxFilter = section[i] + m -1;
            }
        }
        
        return answer;
    }
}
}
