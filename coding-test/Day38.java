class Day38 {
  class Solution {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42889
    //강사님한테 물어볼것
    public int[] solution(int N, int[] lastStages) {
      //고객 숫자
        int nPlayers = lastStages.length;
        //스테이지 배열주소의 숫자를 더함
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }
        //nplayers 복사
        int remainingPlayers = nPlayers;
        //스테이지 객체 리스트 생성
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
          //실패율 계산
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            //실패율 계산을 위한 나머지 플레이어 감소
            remainingPlayers -= nStagePlayers[id];
            //스테이지 객체에 스테이지랑 실패율
            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        //컬렉션.. 스테이지 어레이리스트를 오름차순? 이중배열인데 어떻게?
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    //컴퍼러블 객체
    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }
}
}