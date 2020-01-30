import java.util.Random;

public abstract class Animal {

    private String name = "без клички";

    // не все животные могут плавать,  возможно  в дальнейшем кто-то не сможет  и прыгать -бегать,
    //  по этой  причине поля  с растояними, которые  бегают-плавают-прыгают
    // в абстрактом методе думаю создавать не нужно

    // у животного может быть имя, а может и не быть.
    // По этой причине два конструктора -  без имени и с именем

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    // Кличка  может пояиться у всех животных при создании или  при использовании объекта,
    // по этой причине  думаю создать общие геттеры-сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 //   protected abstract void run();
    // Все   животные в задании умеют бегать и прыгвть. Думаю, эти два метода  можно  разметить в абстрактом классе.
    // коты и птицы  плавать не умеют по заданию, поэтому    метод плавать  в  классе Анимал  размещать  не буду.
    // Но также можно   разместить и  поведение  плавать в  классе Анимал,  а в классе   Кот и Лошадь
    //   методы   плавать  переопределить  , например,  в вывод " Кот Барсик (Лошадь Звезда) не умеет плавать "
    //В книгах пишут, что  для описания поведения  нужно использовать интерфейсы, но это мы ещё не проходили,
    // поэтому использовать их не буду

     abstract void run();

     abstract void jump();

  //  protected abstract void swim();


    //расчет случайного числа  в диапазоне от  мин  до макс  включительно
    final double random (double max, double min) {
        Random rand  = new Random();
      return rand.nextInt(101)/100.0 *(max - min) + min;
    }

}

