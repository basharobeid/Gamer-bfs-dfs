package com.Bashar;

public class State {
    public String[][] puzzle = new String[4][3];
    public int blankX ;
    public int blankY ;

    public State() {
        for(int y =0;y<3;y++) {
            puzzle[0][y] = "RED   ";
            puzzle[1][y] = "GREEN ";
            puzzle[2][y] = "BLUE  ";
            puzzle[3][y] = "YELLOW";
        }
    }

    public boolean win(){
        for (int x = 0;x<4;x++){
            for(int y =0;y<3;y++){
                if((x<3 &&puzzle[x][y] == puzzle[x+1][y]) || (y<2 && puzzle[x][y] == puzzle[x][y+1]))
                    return false;
            }
        }
        return true;
    }

    @Override
    protected State clone() throws CloneNotSupportedException {
        State puz = new State();
        puz.blankX = this.blankX;
        puz.blankY = this.blankY;
        for (int x = 0; x < 4; x++) {
            puz.puzzle[x] = this.puzzle[x].clone();
        }
        return puz;
    }

    public String[] get_next_move(){
        String[] moveAbility = new String[4];
        if(blankY>=0 && blankY<2)
            moveAbility[0] = "Right";
        if (blankX>0 && blankX<=3)
            moveAbility[1] = "Up";
        if(blankY>0 && blankY<=2)
            moveAbility[2] = "Left";
        if (blankX >=0 && blankX<3)
            moveAbility[3] = "Down";
        return moveAbility;
    }
//    public void print_next_move(){
//        for()
//
//
//    }
    public char[] all_char_moves(){
        char[] moves = new char[4];
        if(get_next_move()[0]!=null)
            moves[0] = '6';
        if(get_next_move()[1]!=null)
            moves[1] = '8';
        if(get_next_move()[2]!=null)
            moves[2] = '4';
        if(get_next_move()[3]!=null)
            moves[3] = '2';
        return moves;
    }

    public State move(char input) throws CloneNotSupportedException  {
        State newP = this.clone();
        String[] canMove = newP.get_next_move();
        if (!win()){
           // temp = newP.puzzle[blankX][blankY];
            if((input=='6') && (canMove[0]!= null)){
                //RIGHT
                String temp = newP.puzzle[blankX][blankY];
                newP.puzzle[blankX][blankY] = newP.puzzle[blankX][blankY+1];
                newP.puzzle[blankX][blankY+1] = temp;
                newP.blankY = this.blankY+1;
            } else if ((input == '8') && (canMove[1]!=null)){
                //UP
                String temp = newP.puzzle[blankX][blankY];
                newP.puzzle[blankX][blankY] = newP.puzzle[blankX-1][blankY];
                newP.puzzle[blankX-1][blankY] = temp;
                newP.blankX=this.blankX-1;
            }
            else if ((input=='4') && (canMove[2]!=null)){
                //LEFT
                String temp = newP.puzzle[blankX][blankY];
                newP.puzzle[blankX][blankY] = newP.puzzle[blankX][blankY-1];
                newP.puzzle[blankX][blankY-1] = temp;
                newP.blankY = this.blankY-1;
            }
            else if ((input == '2') && (canMove[3]!=null)){
                //DOWN
                String temp = newP.puzzle[blankX][blankY];
                newP.puzzle[blankX][blankY] = newP.puzzle[blankX+1][blankY];
                newP.puzzle[blankX+1][blankY] = temp;
                newP.blankX=this.blankX+1;
            }
        }
        return newP;
    }
    @Override
    public String toString() {
        String s ="";
        for(int i = 0 ;i<4;i++){
            for(int j= 0 ;j<3;j++)
                s = s + this.puzzle[i][j];
        }
        return s;
    }











}

