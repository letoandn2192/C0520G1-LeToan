package abstract_and_interface.practical.animal_edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: Ò Ó O Ò O...";
    }

    @Override
    public String howToEat() {
        return "Chicken: boiled, fried...";
    }
}
