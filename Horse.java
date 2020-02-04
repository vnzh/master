public class Horse extends Animal {

    //максимальные  значения   бега-плаванья-прыжка
    private final double maxDistRun = 1500;  //500м
    private final double maxDistSwim = 100;
    private final double maxDistJump = 3;
    //минимальные  значения   бега-плаванья-прыжка
    private final double minDistRun = 800;  //500m
    private final double minDistSwim = 70;
    private final double minDistJump = 2.1;

    private double distRun;
    private double distSwim;
    private double distJump;

    public Horse() {
        this.distRun = random(maxDistRun, minDistRun);
        this.distSwim = random (maxDistSwim, minDistSwim);
        this.distJump = random (maxDistJump, minDistJump);
    }
    public Horse(String name) {
        super(name);
        this.distRun = random(maxDistRun, minDistRun);
        this.distSwim = random (maxDistSwim, minDistSwim);
        this.distJump = random (maxDistJump, minDistJump);
    }

    public double getDistRun() {
        return distRun;
    }

    public double getDistSwim() {
        return distSwim;
    }

    public double getDistJump() {
        return distJump;
    }

    @Override
    protected void run() {
        System.out.printf("Лошадь %s пробежал(а)  %6.2f  м!\n",  getName(), getDistRun());
    }

    @Override
    protected void jump() {
        System.out.printf("Лошадь %s прыгнул(а)  %6.2f  м!\n", getName(), getDistJump());
   }


    protected void swim() {
        System.out.printf("Лошадь %s  проплыл(а)  %6.2f  м!\n", getName(), getDistSwim());
    }


}
