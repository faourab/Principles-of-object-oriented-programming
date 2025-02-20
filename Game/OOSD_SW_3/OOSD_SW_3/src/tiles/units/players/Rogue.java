package tiles.units.players;

import GameBoard.SingletonPE;
import View.CLI;
import tiles.units.enemies.Enemy;
import GameBoard.Position;

import java.util.List;

public class Rogue extends Player {
    private int cost;
    private int current_energy;
    private static final int MAX_ENERGY = 100;


    public Rogue(Position p, String name, int hitPoints, int attack, int defense, int cost) {
        super(p, name, hitPoints, attack, defense);
        this.cost = cost;
        this.current_energy = MAX_ENERGY;
    }

    public int healthGain() {
        return super.healthGain();
    }

    public int attackGain() {
        return super.attackGain() + (3 * super.level);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.current_energy = MAX_ENERGY;
        this.Attackpoints += attackGain();
        CLI.sendMessage("Congratulation you leveled up");

    }

    public void ability() {
        if (cost < current_energy) {
            current_energy = current_energy - cost;
            Player p = SingletonPE.getPlayer();
            List<Enemy> listOfenemyInTheRange = SingletonPE.getEnsInRange(2, p.getPosition());
            int amountDamge = p.getAttackPoints();
            if (!listOfenemyInTheRange.isEmpty()) {
                for (Enemy e : listOfenemyInTheRange) {
                    e.getHealth().takeDamage(amountDamge);
                }
            }
            else {
                CLI.sendMessage("No enemies in my range");
            }
        }else {
            CLI.sendMessage("Your current energy isn't enough");
        }
    }

    public void OnGameTick() {
        current_energy=Math.min(current_energy+10,MAX_ENERGY);
    }

}
