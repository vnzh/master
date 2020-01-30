import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class Cat extends Animal {

    //максимальные  значения   бега-плаванья-прыжка
    private final double maxDistRun = 200;  //м

    private final double maxDistJump = 2;
    //минимальные  значения   бега-плаванья-прыжка
    private final double minDistRun = 100;  //m

    private final double minDistJump = 1;

    private double distRun;

    private double distJump;

    public Cat() {
        this.distRun = random(maxDistRun, minDistRun);

        this.distJump = random (maxDistJump, minDistJump);
    }
    public Cat(String name) {
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
        System.out.printf("Кот %s пробежал(а)  %6.2f  м!\n",  getName(), getDistRun());
    }

    @Override
    protected void jump() {
        System.out.printf("Кот  %s  прыгнул(а)  %6.2f  м!\n", getName(), getDistJump());
    }
}
