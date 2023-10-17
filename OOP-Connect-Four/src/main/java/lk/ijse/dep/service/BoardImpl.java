package lk.ijse.dep.service;

public class BoardImpl implements Board {

    private final BoardUI boardUI;

    private static Piece[][] pieces;



    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;

        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        System.out.println("Array initialize");

        setArraytoValues();

    }

    public static Piece[][] getPieces() {return pieces;}

    public void setArraytoValues() {

        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j]=Piece.EMPTY;

            }

        }

    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        System.out.println("Find Available spot");

        for(int i = 0; i < pieces[col].length; i++) {
            if(pieces[col][i].equals(Piece.EMPTY))return i;

        }


        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {

        System.out.println("Is legal Move method");
        int islegal = findNextAvailableSpot(col);
        return islegal != (-1);

    }

    @Override
    public boolean existLegalMoves() {
        boolean temp = false;
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if(pieces[i][j]==Piece.EMPTY){
                    temp = true;
                    break;
                }

            }

        }

        return !temp;
    }

    @Override
    public void updateMove(int col, Piece move) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                pieces[col][i]=move;
                break;
            }

        }

    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }

    @Override
    public Winner findWinner() {
        int col1,col2,row1,row2;
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < 3; j++) {
                if(pieces[j][i]==pieces[j+1][i]&&pieces[j][i]==pieces[j+2][i]&&pieces[j][i]==pieces[j+3][i]){
                    if (pieces[j][i]!=Piece.EMPTY){
                        col1 = j;
                        col2 = j+3;
                        row1 = row2 = i;
                        return new Winner(pieces[j][i],col1,row1,col2,row2);
                    }
                }
            }

        }
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < 2; j++) {
                if (pieces[i][j]==pieces[i][j+1]&&pieces[i][j]==pieces[i][j+2]&&pieces[i][j]==pieces[i][j+3]) {
                    if (pieces[i][j]!=Piece.EMPTY){
                            row1=j;
                            row2=j+3;
                            col1 = col2 =i;
                            return new Winner(pieces[i][j],col1,col2,row1,row2);

                    }
                }


            }

        }

        return new Winner(Piece.EMPTY);
    }
}


