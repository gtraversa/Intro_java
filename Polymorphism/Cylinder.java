package polymorphism.test;

public class Cylinder extends Circle {
    private double h;

    public Cylinder(){super(); h = 0;}
    public Cylinder(int x, int y, double r, double h) {super(x,y,r); setH(h);}

    public double getH(){return h;}
    public void setH(double hval) {h = hval < 0 ? 0: hval;}

    @Override
    public double getArea(){return 2*super.getArea() + 2*Math.PI*getR()*h;}

    @Override
    public double getVolume() { return super.getArea()*h;}

    @Override
    public String getName() {return "Cylinder";}

    @Override
    public String toString() {return super.toString() + "; H = " + h;}
}
