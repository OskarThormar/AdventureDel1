public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;
    private String enemyDescription;

    public Enemy(String enemyName, String enemyDescription, int enemyHealth, int enemyDamage) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
    }
    public String getEnemyName(){
        return enemyName;
    }
    public void setEnemyName(String enemyName){
        this.enemyName = enemyName;
    }
    public int getEnemyDamage(){
        return enemyDamage;
    }
    public void setEnemyDamage(int enemyDamage){
        this.enemyDamage = enemyDamage;
    }
    public int getEnemyHealth(){
        return enemyHealth;
    }
    public void setEnemyHealth(int enemyHealth){
        this.enemyHealth = enemyHealth;
    }
    public String getEnemyDescription(){
        return enemyDescription;
    }
    public void setEnemyDescription(){
        this.enemyDescription = enemyDescription;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Enemies found: \n");
        stringBuilder.append(enemyName);
        stringBuilder.append(", ");
        stringBuilder.append(enemyDescription);
        stringBuilder.append(" - ");
        stringBuilder.append(enemyDamage);
        stringBuilder.append(" damage and ");
        stringBuilder.append(enemyHealth);
        stringBuilder.append("health");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
