import Animals.Animal;
import Animals.Bird;
import org.junit.Test;

public class LambdaExpressionsTest {

    @Test
    public void expressionsToTest(){
        Animal animal = new Animal() {
            @Override
            public String makeSound(String first, String second) {
                return first.concat(second);
            }
        };
        System.out.print(animal.makeSound("guau!", "guau!"));

        Bird flyingBird = new Bird() {
            @Override
            public void move() {
                System.out.print("Flying");
            }
        };
        flyingBird.move();
    }

    @Test
    public void lambdaExpressionWithParameters(){
        //Especificando tipos
        Animal dog = (String first, String second) -> {return first.concat(second);};
        System.out.print(dog.makeSound("guau!","guau!"));

        //Se pueden inferir los tipos en algunas ocasiones
        Animal cat = (first, second) -> {return first.concat(second);};
        System.out.print(cat.makeSound("prrrr!","prrrr!"));

        //Si solo es una línea de implementación se puede quitar el return y las llaves
        Animal human = (first, second) -> first.concat(second);
        System.out.print(human.makeSound("snif!","snif!"));
    }

    @Test
    public void lambdaExpressionWithNoParameter(){

        Bird flyingBird = () -> {System.out.println("Flying");};

        //Se pueden quitar las llaves
        Bird walkingBird = () -> System.out.println("Walking");
    }

}
