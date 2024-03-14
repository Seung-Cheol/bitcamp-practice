public class Day47 {
public class Solution {
    public int solution(int n) {
        //1,2,4,8
        //3,6,9,
        int ans = 1;
        int x = 1;
        while(n>=2) {
            if(n%2==0) {
                n = n/2;
                continue;
            } else {
                ans += 1;
                n  = n -1;
            }
        }

        return ans;
    }
}
  
}
