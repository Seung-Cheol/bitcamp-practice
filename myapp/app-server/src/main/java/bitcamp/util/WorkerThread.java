package bitcamp.util;

public class WorkerThread extends Thread {

  Pooling<WorkerThread> pool;
  Worker worker;

  public WorkerThread(Pooling<WorkerThread> pool) {
    this.pool = pool;
  }

  synchronized public void setWorker(Worker worker) {
    this.worker = worker;
    this.notify();
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (this) {
          this.wait();
        }
        try {
          worker.play();
        } catch (Exception e) {
          System.out.println("클라이언트 처리 중 오류 발생");
          e.printStackTrace();
        }
        //작업을 완료했으면 다시 poll로 되돌아간다.
      }
    } catch (Exception e) {
      System.out.println("스레드 예외 발생!");
      e.printStackTrace();
    }
    pool.revert(this);
  }
}
