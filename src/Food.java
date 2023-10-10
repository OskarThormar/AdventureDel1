public class Food extends Item {
    private int health;

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
        stringBuilder.append("❤\uFE0F ");
        stringBuilder.append(super.name);
        stringBuilder.append(" \u2022 ");
        stringBuilder.append(super.description);
        stringBuilder.append(" \u2022 ");
        stringBuilder.append(health + " health");
        return stringBuilder.toString();
        //return super.name + "\n" + super.description + "\n" + health + "\u2764";
    }
}
