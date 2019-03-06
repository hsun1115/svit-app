import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTasks {
	private static long START_TIME;
	public static void main(String[] args) throws InterruptedException{
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		START_TIME = System.currentTimeMillis();
		Runnable task1=printTask("T1");
		Runnable task2=printTask("T2");
		Runnable task3=printTask("T3");
//		Runnable task4=printTask("T4");
//		Runnable task5=printTask("T5");
		
		ses.scheduleAtFixedRate(task1, 1, 1, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(task2, 2, 2, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(task3, 3, 3, TimeUnit.SECONDS);
//		ses.scheduleAtFixedRate(task4, 6, 5, TimeUnit.SECONDS);
//		ses.scheduleAtFixedRate(task5, 4, 2, TimeUnit.SECONDS);
		
		Thread.sleep(20000);
		ses.shutdown();
		ses.awaitTermination(3000, TimeUnit.SECONDS);
	}
	private static Runnable printTask(String s) {
		return ()->System.out.println(s + ": " + (System.currentTimeMillis() - START_TIME));
	}
}
