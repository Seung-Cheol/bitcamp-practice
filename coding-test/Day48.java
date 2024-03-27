class Day48 {
    class Solution {
        public String solution(String s) {
            String[] strArr= s.split(" ");
            String answer = "";


            for(int i = 0; i<strArr.length; i++) {
                if(strArr[i].equals("")) {
                    answer = answer + " ";
                    continue;
                }
                String first;
                String next;
                if (strArr[i].charAt(0) >= 'a' && strArr[i].charAt(0) <= 'z') {
                    first = strArr[i].substring(0,1).toUpperCase();
                } else {
                    first = strArr[i].substring(0,1);
                }

                if(strArr[i].length()==1) {
                    next = "";
                } else {
                    next = strArr[i].substring(1).toLowerCase();
                }

                if(i+1!=strArr.length) {
                    answer = answer + first + next + " ";
                } else {
                    answer = answer + first + next;
                }
            }
            return answer;
        }
    }
}