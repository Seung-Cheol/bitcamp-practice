public class Day14 {

//빅오(BIG-O란)
//입력값이 커질 때 알고리즘의 실행 시간(공간복잡도)과 함께 공간 요구사항(공간복잡도)이 어떻게 증가하는지를 분류하는 데 사용,
//알고리즘의 효율성을 분석하는 데 매우 유용
//n^2+4n+2 일 때 시간복잡도측면에서는 n^2 만을 따짐. 컴퓨터과학에서는 추이만 따지기 때문
/*
 * public int fn(int n) {
 * return 42;}
 */
//이경우 빅오 1이기 때문에 절대적인 알고리즘. 배열에서 값을 조회할 때, 연결 리스트의 끝에 값을 삽입할 때 해시테이블의 조회 및 삽입 등이 있다

/*
 * public int fn(int) {
 *  while(n > 1) {
 *    n /=2;
 * return n;
 * }
 * }
 */
//연산횟수가 log2N ( n이 4일경우 2), 생략하여 log n,
// log n의 시간복잡도를 가진다면 이 경우도 최고의 알고리즘
//즉 빅오는 몇 번 계산해야하는지를 나타내는 지표이고 n^2 + n 의 경우로 나누어 떨어지는 경우
//최고 고차원인 n^2로 계산한다
//여러 경우의 수 중 최고로 느린 경우를 빅오로 친다
//분할 상환 분석인 경우는 특정 경우에만 시간복잡도가 높아지는 경우 등을 고려하여 시간복잡도를 계산.
// 여러 경우의 수를 나누어 평균을 냄으로써 시간복잡도를 계산


//공간복잡도의 경우 탐색의 경우 n의 시간복잡도, 삽입에는 1의 시간복잡도가 필요한데
//삽입 시 더욱 많은 리소스가 들어감. 이 경우 공간 복잡도가 높다고 표현 가능


/******************** 1. 문자열
 1. charAt(int index) 함수로 추출
 2. toLowerCase로 소문자로 변경 가능. 일관성 유지
 3. char로 변환할 때 isLetterOrDigit(char c)를 통하여 영숫자 판별 가능
 */
String[] logs = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"}
public String[] reorderLogFiles(String[] logs)
  List<String> letterList = new ArrayList<>();
  List<String> digitList = new ArrayList<>();

  for(String log : logs) {
    //로그 종류확인 후 숫자 로그라면 숫자 리스트에 삽입
    if(Character.isDigit(log.Split(" ")[1].charAt(0))) {
      digitList.add(log);
    } else {
      letterList.add(log);
    }
  }

  letterList.sort((s1,s2) {
    String[] s1x = s1.split(" ", 2);
    String[] s2x = s2.split(" ", 2);

    //문자열을 비교해서 비교대상 s2의 1번째가 앞으로 와야한다면 1을 리턴하여 앞으로 보냄
    int compared = s1x[1].compareTo(s2x[1]);

    //만약 문자열이 같다면
    if(compared==0) {
      //식별자끼리 비교하여 s2의 식별자가 앞으로 와야한다면 1을 리턴하여 앞으으로 보냄
      return s1x[0].comparedTo(s2x[0]);
    } else {
      //나머지 경우에는 compared return
      return compared;
    }
  })


  
}
