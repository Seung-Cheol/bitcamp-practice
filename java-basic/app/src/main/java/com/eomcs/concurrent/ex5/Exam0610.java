// synchronized 메서드
package com.eomcs.concurrent.ex5;

public class Exam0610 {
  public static void main(String[] args) {
    Job job = new Job();
    Worker1 w1 = new Worker1("홍길", job);
    Worker2 w2 = new Worker2("꺽정", job);
    Worker3 w3 = new Worker3("관순 ", job);
    Worker4 w4 = new Worker4("중근", job);

    w1.start();
    w2.start();
    w3.start();
    w4.start();

  }
  static class Job {
    void play1(String threadName) throws InterruptedException {
      System.out.println(threadName +"play1 호출");
      Thread.sleep(1000);
    }
    void play2(String threadName) throws InterruptedException {
      System.out.println(threadName+ "play2호출");
      Thread.sleep(1000);
    }
    void play3(String threadName) throws InterruptedException {
      System.out.println(threadName+ "play3 호출");
      Thread.sleep(1000);
    }
  }

  static class Worker1 extends Thread {
    Job job;
    public Worker1(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play1(getName());
        delay();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    private void delay() {
      int delayCount = (int)(Math.random() * 1000);
      for (int i = 0; i < delayCount; i++)
        Math.asin(45.765); // CPU를 뺏길 기회를 제공
    }
  }

  static class Worker2 extends Thread {
    Job job;
    public Worker2(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play2(getName());
        delay();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    private void delay() {
      int delayCount = (int)(Math.random() * 1000);
      for (int i = 0; i < delayCount; i++)
        Math.asin(45.765); // CPU를 뺏길 기회를 제공
    }
  }

  static class Worker3 extends Thread {
    Job job;
    public Worker3(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play3(getName());
        delay();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    private void delay() {
      int delayCount = (int)(Math.random() * 1000);
      for (int i = 0; i < delayCount; i++)
        Math.asin(45.765); // CPU를 뺏길 기회를 제공
    }
  }

  static class Worker4 extends Thread {
    Job job;
    public Worker4(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play3(getName());
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

}
