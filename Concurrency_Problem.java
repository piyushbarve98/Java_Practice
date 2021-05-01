public class Concurrency_Problem extends Thread {
  public static int amount = 0;

  public static void main(String[] args) {
    Concurrency_Problem thread = new Concurrency_Problem();
    thread.start();
    System.out.println(amount);
    amount++;
    System.out.println(amount);
  }

  public void run() {
    amount++;
  }
}