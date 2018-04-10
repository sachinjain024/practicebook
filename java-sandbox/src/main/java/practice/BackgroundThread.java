package practice;

import java.util.concurrent.*;

public class BackgroundThread {
    private static BackgroundWorker worker;
    private static ScheduledExecutorService service;
    private static ScheduledFuture<?> currentTask;

    private static int counter = 0;

    private static int initialDelay = 0;
    private static int peridoicDelay = 1;
    private static final TimeUnit unit = TimeUnit.SECONDS;

    public static void main(String[] args) {
        System.out.println("This is an example of running background thread in java");
        startBackgroundThread();
    }

    private static void startBackgroundThread() {
        worker = new BackgroundWorker();
        service = Executors.newSingleThreadScheduledExecutor(new MyThreadFactory("BackgroundCounterThread-"));
        currentTask = service.scheduleWithFixedDelay(worker, initialDelay, peridoicDelay, unit);
    }

    private static class BackgroundWorker implements Runnable {
        @Override
        public void run() {
            try {
                doWork();
            } catch (Throwable t) {
                System.out.println("Error in background worker");
            }
        }

        // This method will be invoked periodically. Do/Invoke all main actions from here.
        // Before all this was boilerplate code
        private void doWork() {
            System.out.println("Counter value is: " + counter++);
        }
    }

    private static class MyThreadFactory implements ThreadFactory {

        private String threadName;

        MyThreadFactory(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, threadName);

            // Kill the thread if the main application dies. In your long running app, set it as daemon thread
            // In this particular case, it is not a lon running service so we are not creating daemon thread
            // t.setDaemon(true);
            return t;
        }
    }
}
