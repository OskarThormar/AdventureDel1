public class Food extends Item {
    private int health;
    private boolean isFood;

    public Food(String name, String description, int health){
        super(name, description);
        this.health = health;
    }

    public void foodObjekt(){
        System.out.println("You found food!");
    }
    public int getHealth(){
        return health;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.name);
        stringBuilder.append("");
        stringBuilder.append(" - ");
        stringBuilder.append(super.description);
        stringBuilder.append(" - ");
        stringBuilder.append(health);
        stringBuilder.append("\u2764");
        return stringBuilder.toString();
        //return super.name + "\n" + super.description + "\n" + health + "\u2764";
    }
}
