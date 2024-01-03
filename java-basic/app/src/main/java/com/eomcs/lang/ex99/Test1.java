package com.eomcs.lang.ex99;
import java.io.InputStream;
import java.util.Scanner;

//어디에 있는지 알려주는 용

public class Test1 {
  private Test1() {};
  public static void main(String[] args) throws Exception {
    InputStream in = System.in;
    Scanner keyIn = new Scanner(in);
    String str = keyIn.nextLine();
    System.out.println("===>" + str );
    keyIn.close();
  }

  static final InputStream in = null;
}
