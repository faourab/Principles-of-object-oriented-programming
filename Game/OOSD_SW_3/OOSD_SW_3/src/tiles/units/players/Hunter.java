package tiles.units.players;
import GameBoard.SingletonPE;
import View.CLI;
import tiles.units.enemies.Enemy;
import GameBoard.Position;

import java.util.List;

public class Hunter extends Player{
    protected int range;
    protected int arrowsCount;
    protected int ticksCount;

    public Hunter(Position p,String name, int hitPoints, int attack, int defense, int range) {
        super(p,name, hitPoints, attack, defense);
        this.range = range;
        this.arrowsCount = super.level*10;
        this.ticksCount = 0;
    }

    public int defenseGain(){
        return super.defenseGain() + super.level;
    }
    public int attackGain(){
        return super.attackGain() + (2*super.level);
    }
    @Override
    public void levelUp(){
        super.levelUp();
        this.arrowsCount += super.level*10;
        int defenseGain = defenseGain();
        this.Defensepoints += defenseGain();
        int attackGain = attackGain();
        this.Attackpoints += attackGain;

        CLI.sendMessage("Congratulation you leveled up");
    }

    public void OnGameTick(){
        if (ticksCount == 10){
            arrowsCount += super.level;
            ticksCount = 0;
        }
        else ticksCount++;

    }

    public void ability() {
        List<Enemy> listOfenemyInTheRange = SingletonPE.getEnsInRange(range, this.getPosition());

        if (!listOfenemyInTheRange.isEmpty()) {
            if (arrowsCount > 0) {
                arrowsCount--;
                Enemy e =getMin(listOfenemyInTheRange);
                this.battle(e);

            }else {
                CLI.sendMessage("You dont have enough arrows");
            }
        }else {
            CLI.sendMessage("No enemies in your range");
        }

    }
     public Enemy getMin(List<Enemy> l){
        double[] ranges = new double[l.size()];
        for (int i = 0 ; i < ranges.length ; i++){
            ranges[i]= this.position.range(l.get(i).getPosition());
        }
        double min = ranges[0];
        int ind=0;
         for (int i = 1; i < ranges.length; i++) {
             if (ranges[i]<min) {
                 min = ranges[i];
                 ind =i;
             }
         }
         return l.get(ind);

     }

}
