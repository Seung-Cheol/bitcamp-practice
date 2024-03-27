import java.util.*;
public class Day27 {
class Solution {
    public int[] solution(int n, int m) {
        //유클리드 호제법 적용하기
        int max;
        int min;
        int[] answer = new int[2];
        if(m>n) {
            max = m;
            min = n;
        } else {
            max = n;
            min = m;
        }
        answer[0] = sl2(max,min);
        //최소공배수는 두 수를 곱하고 최대공약수로 나눈 수이다.
        answer[1] = (max*min)/answer[0];
        return answer;
    }
    
    int sl2(int a, int b) {
        if(b==0) {
            return a;
        } else {
            return sl2(b, a%b);
        }
    }
}
}
