package org.example;
import java.util.*;

class Coordinate {
    int x, y;
    String path;
    Coordinate(int i, int j,String str)
    {
        this.x = i;
        this.y = j;
        this.path=str;
    }
}

public class DroneSearch {
    static void findPath(int[][] M, ArrayList<Coordinate>Path)
    {
        Queue<Coordinate> q = new LinkedList<>();

        int R =14;
        int C = 12;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (M[i][j] == 1) {
                    String t = "";
                    q.add(new Coordinate(i, j, t));
                }
            }
        }

        while (q.size() != 0) {
            Coordinate point = q.peek();
            q.remove();
            int i = point.x;
            int j = point.y;

            if (i < 0 || i >= R || j < 0 || j >= C)
                continue;
            String t = "["+i+":"+j+"]";
            if (M[i][j] == 2) {
                System.out.println("The Possible path:");
                point.path+= t;
                System.out.println(point.path);
                break;
            }

            q.add(new Coordinate(i -1, j,point.path+t));
            q.add(new Coordinate(i,j+1,point.path+t));
            q.add(new Coordinate(i+1, j,point.path+t));
            q.add(new Coordinate(i,j-1,point.path+t));

        }
    }
    public static void main(String[] args) {
        int Grid[][] = {
                {1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the x, y value for target :");
        int x = sc.nextInt();
        int y = sc.nextInt();
        Grid[x][y] = 2;
        findPath(Grid,new ArrayList<Coordinate>());
    }
}