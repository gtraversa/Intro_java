package polymorphism.test;

public interface Shapes {
    public String getName();

    @Override
    public String toString();

    public double getArea();

    public double getVolume();
}
