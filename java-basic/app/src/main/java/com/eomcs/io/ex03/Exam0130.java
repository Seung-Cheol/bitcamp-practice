// character stream - 문자 단위로 읽기
package com.eomcs.io.ex03;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.*;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    // 1) 파일의 데이터를 읽을 객체를 준비한다.
    // => 읽어들일 파일의 문자집합이 file.encoding 환경변수에 지정된 값과 다르다면,
    //    다음과 같이 출력 스트림을 생성할 때 파일의 문자집합을 알려줘라.
    FileReader in = new FileReader("sample/ms949.txt", Charset.forName("MS949")); // 41 42 b0 a1 b0 a2

    int ch;
    while((ch=in.read())!=-1) {
      System.out.printf("%04x ", ch);
    }
    System.out.printf("file.encoding=%s\n", System.getProperty("file.encoding"));

    in.close();
  }

  <E> void test(<E> e) {
    return;
  }
}






