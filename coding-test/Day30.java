public class Day30 {
  class Solution {
    public int solution(int n) {
        String a = "";

        while(n > 0){
            //n진수 구하는 법은 n으로 나눴을 때 나머지값을 뒷쪽부터 붙이는구나.
            //n을 3으로 나눈 나머지를 a에 더한다
            a = (n % 3) + a;
            //n을 3으로 나눈다 n은 int이므로 나머지는 버려진다.
            //45 -> 15 -> 5 -> 1    1200
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();

        //String 3진수를 10진수의 int값으로 변환
        return Integer.parseInt(a,3);
    }
}

}
