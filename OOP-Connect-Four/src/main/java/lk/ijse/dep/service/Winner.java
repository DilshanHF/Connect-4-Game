package lk.ijse.dep.service;

public class Winner {


    private int col1;
    private int col2;

    private int row1;
    private int row2;

    private Piece winningPiece;


    Winner(){

    }
        Winner(Piece winningPiece){
            this.winningPiece = winningPiece;
            this.col1 = -1;
            this.col2 = -1;
            this.row1 = -1;
            this.row2 = -1;

        }
    Winner(Piece winningPiece,int col1,int col2,int row1,int row2){
        this.winningPiece = winningPiece;
        this.col1=col1;
        this.row1=row1;
        this.col2=col2;
        this.row2=row2;

    }

    public String toString(){
        return "Winner{" +
                "winningPiece=" + winningPiece +
                ", col1=" + col1 +
                ", row1=" + row1 +
                ", col2=" + col2 +
                ", row2=" + row2 +
                '}';
    }

    public Piece getWinningPiece() {

        return winningPiece;


    }

    public int getCol1() {

        return 0;
    }

    public int getCol2() {

        return 0;
    }

    public int getRow2() {

        return 0;
    }

    public int getRow1() {

        return 0;
    }
}
