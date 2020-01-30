

public class Dog extends Animal {

    //максимальные  значения   бега-плаванья-прыжка
    private final double maxDistRun = 500;  //500м
    private final double maxDistSwim = 10;
    private final double maxDistJump = 0.5;
    //минимальные  значения   бега-плаванья-прыжка
    private final double minDistRun = 350;  //500m
    private final double minDistSwim = 7;
    private final double minDistJump = 0.35;

     private double distRun;
     private double distSwim;
     private double distJump;

    public Dog() {
        this.distRun = random(maxDistRun, minDistRun);
        this.distSwim = random (maxDistSwim, minDistSwim);
        this.distJump = random (maxDistJump, minDistJump);
    }
    public Dog(String name) {
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
       System.out.printf("Собака %s   пробежал(а)  %6.2f  м\n",  getName(), getDistRun());
    }

    @Override
    protected void jump() {
       System.out.printf("Собака %s   прыгнул(а)  %6.2f  м!\n", getName(), getDistJump());
    }


    protected void swim() {
        System.out.printf("Собака %s  проплыл(а)  %6.2f  м!\n", getName(), getDistSwim());
    }


}
