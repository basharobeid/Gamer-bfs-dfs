package com.Bashar;

import java.util.Scanner;

public class Player {

    State game = new State();
    Scanner scan = new Scanner(System.in);
        public void play() throws CloneNotSupportedException {
            while (true) {
                System.out.println("X of Blank :");
                boolean is_i = scan.hasNextInt();
                if (is_i) {
                    game.blankX = scan.nextInt();
                    System.out.println("Y of Blank");
                    boolean is_j = scan.hasNextInt();
                    if (is_j) {
                        game.blankY = scan.nextInt();
                        if (game.blankX >= 0 && game.blankX < 4 && game.blankY >= 0 && game.blankY < 3) {
                            game.puzzle[game.blankX][game.blankY] = "WHITE";
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                scan.nextLine();
            }


            for (int i = 0; i < 4; i++) {
                System.out.println(game.puzzle[i][0] + "\t" + game.puzzle[i][1] + "\t" + game.puzzle[i][2] + "\n");
            }
            while (true) {
                //State nGame = game.clone();
                char dir = scan.next().charAt(0);
                game.get_next_move();
                game = game.move(dir);
                for (int i = 0; i < 4; i++) {
                    System.out.println(game.puzzle[i][0] + "\t" + game.puzzle[i][1] + "\t" + game.puzzle[i][2] + "\n");

                }
                if (game.win()) {
                    System.out.println("YOU WIN");
                    break;
                }

            }
            scan.close();
        }



    }



