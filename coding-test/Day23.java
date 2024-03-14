public class Day23 {
//https://school.programmers.co.kr/learn/courses/30/lessons/42862#
//틀린 오답
  class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        for(int i = 0; i<lost.length-1; i++) {
            if(lost[i] > lost[i+1]) {
                int temp;
                temp = lost[i+1];
                lost[i+1] = lost[i];
                lost[i] = temp;
            }
        }
        
        for(int num1 : lost) {
            for(int i=0; i<reserve.length; i++) {
                if(num1-1 <= reserve[i] && num1+1 >= reserve[i]) {
                    answer++;
                    reserve[i] = -2;
                    break;
                }
            }
        }
        answer += n-lost.length;
        return answer;
    }
}
//그리디 알고리즘
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
      //인원수만큼 배열 생성
        int[] people = new int[n];
        //참여할 수 있는 인원 수 초기세팅
        int answer = n;

        //1번부터이므로 4번이라면 3배열 선택. 이 경우 -1
        for (int l : lost) 
            people[l-1]--;
        //여벌 있으면 +1
        for (int r : reserve) 
            people[r-1]++;
        //즉 여벌이 있으면 1, 잃어버렸으면 -1, 여벌이 있으나 잃어버렸다면 0. 둘 다 해당되지 않아도 0

        for (int i = 0; i < people.length; i++) {
          // 만약 잃어버렸을때
            if(people[i] == -1) {
              //i가 1보다 크거나 같고 이전 배열의 수가 1일때. 즉 여분이 있을 때
                if(i-1>=0 && people[i-1] == 1) {
                  //해당 배열은 +1
                    people[i]++;
                  //여분의 배열은 -1하여 0
                    people[i-1]--;
                    //만약 i<length-1일 때. 즉 최소, 마지막 배열 이전일때. 그 때 이후 배열의 수가 1일때
                }else if(i+1< people.length && people[i+1] == 1) {
                  //마찬가지로 해당 배열 +1, 여분의 배열은 -1하여 0
                    people[i]++;
                    people[i+1]--;
                }else 
                //그것도 아닌 경우. people은 -1인 상태 그대로이므로 인원에서 감소
                    answer--;
            }
        }
        return answer;
    }
}

}
