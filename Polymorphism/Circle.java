package polymorphism.test;

public class Circle extends Point{
    private double r;                                                   //Private instance variable

    public Circle(){super(); setR(r);}                                  //Null constructor using superclass
    public Circle(int x, int y, double rval) {super(x,y); r = rval;}    //Constructor with parameters

    public double getR() {return r;}
    public void setR(double rval) {r = rval < 0 ? 0: rval;}             //Method to ser the radius variable using
                                                                        //ternary operator condition

    @Override
    public double getArea() { return Math.PI*r*r;}

    @Override
    public String getName() {return "Circle";}

    //This method combines the superclass' to string method with the extra variuables that need to be printed in this class
    @Override
    public String toString() {return "C = " + super.toString() + ";R = " + r;}
}
