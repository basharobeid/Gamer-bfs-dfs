package com.Bashar;

import java.util.*;

public class Bfs {
    Queue<State> bfs = new LinkedList<State>();
    Scanner scan = new Scanner(System.in);
    public Set<String> visited = new LinkedHashSet<String>();
    State game = new State();


    public void startb() throws CloneNotSupportedException {
        while (true) {
            System.out.println("X of Blank");
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
        scan.close();
        for (int i = 0; i < 4; i++) {
            System.out.println(game.puzzle[i][0] + "\t" + game.puzzle[i][1] + "\t" + game.puzzle[i][2] + "\n");
        }
        this.bfs.add(game);
        while(!this.bfs.isEmpty()) {
            if (game.win()) {
                System.out.println("YOU WIN!!!");
                System.out.println(visited.size());
                break;
            }
            else {
                State newPuzzel = new State();
                game = bfs.poll();
                game.get_next_move();
                char[] mm = game.all_char_moves();
                for (char s : mm) {
                    newPuzzel = game.move(s);
                    if (!this.visited.contains(newPuzzel.toString())) {
                        this.visited.add(newPuzzel.toString());
                        System.out.println("\n");
                        for (int i = 0; i < 4; i++) {
                            System.out.println(newPuzzel.puzzle[i][0] + "  " + newPuzzel.puzzle[i][1] + "  " + newPuzzel.puzzle[i][2] + "\n");
                        }
                        if (bfs != null) {
                            bfs.add(newPuzzel);
                        }
                    }
                }
            }
        }

    }



}
