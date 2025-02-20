package GameBoard;
public class Position {
    private int row;
    private int col;

    public Position(int row,int col){

        this.row = row;
        this.col = col;
    }



    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public void setCol(int _col){
        this.col = _col;
    }
    public void setRow(int _row){
        this.row = _row;
    }

    public boolean equals(Position pos){
        return (row==pos.getRow()) & (col==pos.getCol());
    }
    public double range(Position p) {
        return Math.sqrt(Math.pow(this.row - p.row, 2) + Math.pow(this.col - p.col, 2));

    }


}
