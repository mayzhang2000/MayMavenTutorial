package Utils;

import java.util.concurrent.*;

/**
 * Created by mayz985 on 6/23/17.
 */
public final class ProcessWithTimeout {

    private static final ExecutorService cachedExecutorService = Executors.newCachedThreadPool();

    private ProcessWithTimeout() {
    }

    public static <T> T execute(Callable<T> pCallable, String pDescription, long pTimeoutQuantity, TimeUnit pTimeUnit) {
        Future<T> future = cachedExecutorService.submit(pCallable);

        try {
            return future.get(pTimeoutQuantity, pTimeUnit);
        } catch (TimeoutException e) {
            future.cancel(true);
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) e.getCause();
            }
            throw new RuntimeException(e);
        }
    }
}
