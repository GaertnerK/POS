import java.util.Random;

public class Orc implements Runnable{
    private int orcNr;
    private Dagger leftDagger;
    private Dagger rightDagger;
    private boolean leftDaggerGrabed;
    private boolean rightDaggerGrabed;
    Orc(Dagger leftDagger, Dagger rightDagger, int orcNr){
        this.orcNr = orcNr;
        this.leftDagger = leftDagger;
        this.rightDagger = rightDagger;
        this.leftDaggerGrabed = false;
        this.rightDaggerGrabed = false;
    }

    public void drinking() throws InterruptedException {
        Random random = new Random();
        System.out.println("Drinking:" + orcNr + System.currentTimeMillis());
        Thread.sleep(random.nextLong(1000));
    }

    public void feasting() throws InterruptedException {
        Random random = new Random();
        System.out.println("Feasting:" + orcNr + System.currentTimeMillis());
        Thread.sleep(random.nextLong(1000));
    }

    public boolean grabRightDagger(){
        if (rightDagger.getLock().tryLock()){
            rightDagger.getLock().lock();
            System.out.println("RightDagger grabbed " + orcNr + " : " + System.currentTimeMillis());
            this.rightDaggerGrabed = true;
            return true;
        }else {
            System.out.println("RightDagger not grabbed " + orcNr + " : " + System.currentTimeMillis());
            return false;
        }
    }

    public boolean grabLeftDagger(){
        if (leftDagger.getLock().tryLock()){
            leftDagger.getLock().lock();
            System.out.println("LeftDagger grabbed " + orcNr + " : " + System.currentTimeMillis());
            this.leftDaggerGrabed = true;
            return true;
        }else {
            System.out.println("LeftDagger not grabbed " + orcNr + " : " + System.currentTimeMillis());
            return false;
        }
    }

    public void releaseRightDagger(){
        rightDagger.getLock().unlock();
        System.out.println("RightDagger released " + orcNr + " : " + System.currentTimeMillis());
    }

    public void releaseLeftDagger(){
        leftDagger.getLock().unlock();
        System.out.println("LeftDagger released " + orcNr + " : " + System.currentTimeMillis());
    }

    @Override
    public void run() {
        try {
            drinking();
        } catch (InterruptedException e) {
            System.out.println("Drinking failed");
        }
        while(true){
            try {
                drinking();
            } catch (InterruptedException e) {
                System.out.println("Drinking or feasting interrupted");
            }
            if(grabRightDagger()){
                if(grabLeftDagger()) {
                    try {
                        drinking();
                    } catch (InterruptedException e) {
                        System.out.println("Drinking or feasting interrupted");
                    }
                }
            }
            try {
                feasting();
            } catch (InterruptedException e) {
                System.out.println("Feasting failed");
            }
            if(!grabRightDagger()) {
                releaseRightDagger();
                releaseLeftDagger();
            }
        }
    }
}
