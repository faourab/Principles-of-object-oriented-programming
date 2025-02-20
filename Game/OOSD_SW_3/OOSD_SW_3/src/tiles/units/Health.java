package tiles.units;

public class Health {
    private double capacity;
    private double current;

    public Health(int capacity) {
        this.capacity = capacity;
        this.current = capacity;
    }

    public int takeDamage(int damageTaken) {
        damageTaken = Math.max(0, damageTaken);
        damageTaken =(int) Math.min(current, damageTaken);
        current = current - damageTaken;
        return damageTaken;
    }

    public double getCurrent() {
        return current;
    }
    public double getCapacity() {
        return capacity;
    }

    public void increaseMax(int healthGain) {
        capacity =capacity + healthGain;
    }

    public void heal() {
        current = capacity;
    }
    public void setCurrent(int health){
        int newCUrrent = (int) this.current+health;
         int newhealth = (int )Math.min(capacity,newCUrrent);
        current = newhealth;
    }
    public void setCapacity(int health){
        capacity = health;
    }

}
