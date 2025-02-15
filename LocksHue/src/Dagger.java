import java.util.concurrent.locks.ReentrantLock;

public class Dagger {
    private ReentrantLock lock;
    public Dagger() {
        lock = new ReentrantLock();
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
