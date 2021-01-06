package polymorphism.test;

public class Point implements Shapes {
    private int x; private int y;                           //private instance variables for convention

    public Point() {x = 0; y = 0;}                          //Null constructor
    public Point(int xval, int yval) {x = xval; y = yval;}  //Constructor with expected parameters

    //Conventional methods to access and set the instance variables
    public int getX() {  return x;}
    public int getY() {  return y;}
    public void setX(int newVal) {  x = newVal;}
    public void setY(int newVal) {  x = newVal;}

    @Override
    public String getName() {return "Point";}

    @Override
    public String toString() {return "[" + x + ", " + y + "]"; }

    @Override
    public double getArea() {return 0;}

    @Override
    public double getVolume() {return 0;}
}
