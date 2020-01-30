public class Bird extends Animal {

    //максимальные  значения   бега-плаванья-прыжка
    private final double maxDistRun = 5;  //м

    private final double maxDistJump = 0.2;
    //минимальные  значения   бега-плаванья-прыжка
    private final double minDistRun = 3.3;  //m

    private final double minDistJump = 0.13;

    private double distRun;

    private double distJump;

    public Bird() {
        this.distRun = random(maxDistRun, minDistRun);

        this.distJump = random (maxDistJump, minDistJump);
    }
    public Bird(String name) {
        super(name);
        this.distRun = random(maxDistRun, minDistRun);

        this.distJump = random (maxDistJump, minDistJump);
    }

    public double getDistRun() {
        return distRun;
    }

    public double getDistJump() {
        return distJump;
    }

    @Override
    protected void run() {
        System.out.printf("Птица %s пробежал(а)  %6.2f  м!\n",  getName(), getDistRun());
     }

    @Override
    protected void jump() {
        System.out.printf("Птица %s прыгнул(а)  %6.2f  м!\n", getName(), getDistJump());
    }
}
