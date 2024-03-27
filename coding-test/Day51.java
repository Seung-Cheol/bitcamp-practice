public class Day51 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/70129
  class Solution {
    int zeroCount = 0;
    int binaryCount = 0;
    public int[] solution(String s) {
        binary(s);
        return new int[]{binaryCount,zeroCount};
    }
    public void binary(String x) {
        binaryCount++;
        String temp = "";
        for(int i = 0; i<x.length(); i++) {
            if(x.charAt(i)=='0') {
                zeroCount++;
            }
            if(x.charAt(i)=='1') {
                temp += "1";
            }
        }
        String answer = "";
        int value = temp.length();
        while(value>0) {
            answer = value%2 + answer;
            value = value/2;
        }
        if(!answer.equals("1")) {
            binary(answer);
        }
    }        
}
}
