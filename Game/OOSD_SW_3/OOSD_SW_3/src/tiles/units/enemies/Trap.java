package tiles.units.enemies;
import GameBoard.SingletonPE;
import GameBoard.Position;

public class Trap extends Enemy {

    private int visibility_time;
    private int invisibility_time;
    private int ticks_count;
    private boolean visible;

    public Trap(Position p, char tile, String name, int hitPoints, int attack, int defense, int experienceValue, int visibility_time, int invisibility_time) {
        super(p, tile, name, hitPoints, attack, defense, experienceValue);

        this.visibility_time = visibility_time;
        this.invisibility_time = invisibility_time;
        this.ticks_count = 0;
        this.visible = true;
    }

    public Position gameTick() {
        visible = ticks_count < visibility_time ;
        if (ticks_count == visibility_time + invisibility_time)
            ticks_count = 0;
        else
            ticks_count++;
        if(SingletonPE.getPlayer().getRange(this)<2){
            this.visit(SingletonPE.getPlayer());
        }

        return this.position;

    }
}
