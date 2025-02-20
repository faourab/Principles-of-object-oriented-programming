package tiles;
import  tiles.units.Unit;
import tiles.units.enemies.Enemy;
import tiles.units.players.Player;
import GameBoard.Position;


public abstract class Tile implements Visitor{
    protected char tile;
    protected Position position;

    public Tile(Position _pos,char _tile){
       this.tile = _tile;
       this.position= _pos;
    }

    public void setPosition(Position _p){
        this.position = _p;
    }



    public double getRange(Tile t){
        return  this.position.range(t.position);
    }

    public Position getPosition() {////////////////////////after
        return position;
    }

    public char getTile() {
        return tile;
    }
    public String toString(){
        String ans = "";
          ans = ans +tile;
        return ans ;
    }
    protected void setTile(char c){
        tile = c;
    }

    public  void accept(Unit v){}
    public   void visit(Enemy e){}
    public  void visit(Player p) {}
    public  void visit(Wall w){}
    public void visit(Empty e) {
        Position oldEmptyPosition = e.getPosition();
        e.setPosition(this.position);
        this.position = oldEmptyPosition;
    }

}
