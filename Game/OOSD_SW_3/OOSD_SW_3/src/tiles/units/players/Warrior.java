package tiles.units.players;
import GameBoard.SingletonPE;
import View.CLI;
import tiles.Visitor;
import tiles.units.enemies.Enemy;
import GameBoard.Position;

import java.util.List;

public class Warrior extends Player implements Visitor{
    private int ability_cooldown;
    private int remaining_cooldown;
    private final int  ZERO =0;

    public Warrior(Position p,String name, int hitPoints, int attack, int defense, int ability_cooldown) {
        super(p, name, hitPoints, attack, defense);
        this.ability_cooldown = ability_cooldown;
        remaining_cooldown = ZERO;

    }
    public int healthGain(){
        return super.healthGain()+ (5*super.level);
    }
    public int attackGain(){
        return super.attackGain() + (2*super.level);
    }
    public int defenseGain(){
        return super.defenseGain() + super.level;
    }
    @Override
    public void levelUp(){
        super.levelUp();
        this.remaining_cooldown = 0;
        int attackGain = attackGain();
        this.Attackpoints += attackGain;
        int defenseGain = defenseGain();
        int healthGain = healthGain();
        health.increaseMax(healthGain);
        this.Defensepoints += defenseGain;
        CLI.sendMessage("Congratulation you leveled up");

    }
    public void ability(){
        if(remaining_cooldown == 0){
            this.remaining_cooldown = ability_cooldown;
            int health = (int) Math.min(this.health.getCurrent()+(this.level*10),this.health.getCapacity());
            this.health.setCurrent(health);
            Player player = SingletonPE.getPlayer();
            List<Enemy> listOfenemyInTheRange = SingletonPE.getEnsInRange(3,player.getPosition());
            if(!listOfenemyInTheRange.isEmpty()) {
                int amountHit = (int)( (10/100) * this.health.getCapacity());
                int randomIndex = (int)(Math.random()*listOfenemyInTheRange.size());
                Enemy e = listOfenemyInTheRange.get(randomIndex);
                e.getHealth().takeDamage(amountHit);
            }else {
                CLI.sendMessage("No enemies in my range");
            }

        }else {
            CLI.sendMessage("Wait until your cool down is 0000000000");

        }
    }
    public void OnGameTick() {
        remaining_cooldown=remaining_cooldown-1;
    }




}
