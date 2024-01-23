package com.eomcs.reflect.ex06.a;

import java.lang.reflect.Proxy;

public class Exam121 {
  public static void main(String[] args) {
    Class<?>[] interfaceTypes = new Class<?>[] {A.class, B.class, C.class};

    Object obj = Proxy.newProxyInstance(
        Exam121.class.getClassLoader(),
        new Class<?>[] {A.class, B.class, C.class},
        (proxy, method, params) -> {
          System.out.println(method.getName());
          return null;
        });

    ((A) obj).m1();
    ((B) obj).m2();
    ((C) obj).m3();
  }
}
