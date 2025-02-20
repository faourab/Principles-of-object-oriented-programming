package tiles.units.players;
import GameBoard.SingletonPE;
import View.CLI;
import tiles.units.enemies.Enemy;
import GameBoard.Position;

import java.util.List;

public class Mage extends Player {
    private int mana_poool;
    private int current_mana;
    private int mana_cost;
    private int spell_power;
    private int hits_count;
    private int ability_range;

    public Mage(Position pos, String name, int hitPoints, int attack, int defense, int mana_poool, int mana_cost, int spell_power, int hits_count, int ability_range) {
        super(pos, name, hitPoints, attack, defense);
        this.mana_poool = mana_poool;
        this.current_mana = (mana_poool)/4;
        this.mana_cost = mana_cost;
        this.spell_power = spell_power;
        this.hits_count = hits_count;
        this.ability_range = ability_range;
    }

    public int healthGain() {
        return super.healthGain();
    }

    public int attackGain() {
        return super.attackGain();
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.mana_poool += mana_poool + (25 * super.level);
        this.current_mana = Math.min(this.current_mana + (mana_poool / 4), mana_poool);
        this.spell_power += (10 * super.level);
        CLI.sendMessage("Congratulation you leveled up");

    }

    public void ability() {
        if(mana_cost <= current_mana){
            current_mana-=mana_cost;
            int hits=0;
            Player player = SingletonPE.getPlayer();
            List<Enemy> listOfenemyInTheRange = SingletonPE.getEnsInRange(ability_range,player.getPosition());
            if(listOfenemyInTheRange.isEmpty())   CLI.sendMessage("No enemies in your range");

            while(hits<hits_count & !listOfenemyInTheRange.isEmpty()){
                int randomIndex = (int)(Math.random()*listOfenemyInTheRange.size());
                Enemy e = listOfenemyInTheRange.get(randomIndex);
                e.getHealth().takeDamage(spell_power);
                hits++;
            }
        }
        else CLI.sendMessage("Your mana count is not enough ");

    }

    public void OnGameTick() {
        current_mana = Math.min(mana_poool,current_mana+SingletonPE.getPlayer().getPlayerLevel());
    }
}



