public class Day3 {
  class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int k = t.length() - p.length() + 1;
        for(int i=0; i<k; i++) {
            String temp = "";
            for(int a=0; a<p.length(); a++) {
                temp += t.charAt(a+i);
            }
            //charAt(n) = 문자열의 n번째 출력
            if(Integer.parseInt(p)>=Integer.parseInt(temp)) {
                answer += 1;
            }
            //문제 조건에서 p가 18자리까지 가능하므로 20억대 숫자 이상이 올 수 있었다. 그래서 Integer가 아닌 Double로 형변환 해야함
            //그래서 Double.parseDouble(p) >= Double.parseDouble(temp)
            temp = "";
        }
        return answer;
    }
  }
}
