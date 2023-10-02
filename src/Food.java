public class Food extends Item {
    private int health;

    public Food(String name, String description, int health){
        super(name, description);
        this.health = health;

    }

    public void foodObjekt(){
        System.out.println("food");

    }
    public int getHealth(){
        return health;
    }



}
