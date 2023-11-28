public class Day6 {

import java.util.*;

//내가 풀었던 부분
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> honor = new ArrayList<>();
        //https://school.programmers.co.kr/learn/courses/30/lessons/138477#
        //경우의 수 ( 분기점이 2가지가 있음 )
        //k와 score의 길이에 따라서 k가 큰지 score.length가 큰지에 따라 결정
        if(score.length>=k) {
            for(int i = 0; i<k; i++) {
                honor.add(score[i]);
                honor.sort(Comparator.naturalOrder());
                answer[i] = honor.get(0);

            }
        } else {
            for(int i=0; i<score.length; i++) {
                honor.add(score[i]);
                honor.sort(Comparator.naturalOrder());
                answer[i] = honor.get(0);
            }
        }
        
        for(int i = k; i<score.length; i++) {
            int min = Collections.min(honor);
            if(score[i] > min) {
                honor.add(score[i]);
                honor.sort(Comparator.naturalOrder());
                honor.remove(0);
                answer[i] = honor.get(0);
            } else {
                answer[i] = honor.get(0);
            }
        }
    
        return answer;
    }
}


//다른 사람의 풀이
class Solution {
  public int[] solution(int k, int[] score) {
      int[] answer = new int[score.length];

      //PriorityQueue(우선순위 큐)
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

      int temp = 0;

      for(int i = 0; i < score.length; i++) {
          //큐에 스코어 저장
          priorityQueue.add(score[i]);

          //큐 사이즈가 k보다 크면 poll (첫번째 값 반환 후 버림; 이 때 첫번째 값은 우선순위 큐이므로 가장 낮은 숫자)
          //이 때 k보다 크다는 뜻은 명예의 전당 이상의 사이즈이므로 제거를 해야하는데 이 때 가장 낮은 숫자를 제거한다는 뜻
          if (priorityQueue.size() > k) {
              priorityQueue.poll();
          }
          //가장 낮은 숫자를 제거했으므로(전당 범위 초과) 전당 범위 내에서 가장 낮은 숫자 픽하여 answer에 입력
          answer[i] = priorityQueue.peek();
      }



      return answer;
  }
}
  
}
