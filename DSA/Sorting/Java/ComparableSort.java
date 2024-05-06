import java.util.*;
public class ComparableSort{
    public static void main(String[] args) {
        Point p[] = {new Point(1, 10), new Point(25, 31), new Point(3, 9)};
        Arrays.sort(p/* , new PointComparator()*/);
        for(int i = 0; i<p.length; i++){
            System.out.println("(" + p[i].x + ", " + p[i].y + ")");
        }
    } 
}

/*class Point{
    int x, y;
    Point(int x , int y){
        this.x = x;
        this.y = y;
    }
}

class PointComparator implements Comparator<Point>{
    public int compare(Point p1, Point p2){
        return p1.x - p2.x;
    }
}*/

class Point implements Comparable<Point>{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int compareTo(Point p){
        return this.x - p.x;
    }

}

