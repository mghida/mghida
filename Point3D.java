package primitives;

import java.util.Objects;

public class Point3D {

    protected Coordinate X;
    protected Coordinate Y;
    protected Coordinate Z;
    public static  Point3D ZERO=new Point3D(0,0,0);

    public Point3D (Coordinate x, Coordinate y, Coordinate  z)
    {
        this.X=x;
        this.Y=y;
        this.Z=z;
    }

    public Point3D (double x, double y, double  z)
    {

        this.X=new Coordinate(x);
        this.Y=new Coordinate(y);
        this.Z=new Coordinate(z);
    }
    public Point3D(Point3D a) {
        this.X=a.X;
        this.Y=a.Y;
        this.Z=a.Z;
    }


    public Coordinate getX() {
        return X;
    }

    public void setX(Coordinate x) {
        X = x;
    }

    public Coordinate getY() {
        return Y;
    }

    public void setY(Coordinate y) {
        Y = y;
    }

    public Coordinate getZ() {
        return Z;
    }

    public void setZ(Coordinate z) {
        Z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Objects.equals(X, point3D.X) &&
                Objects.equals(Y, point3D.Y) &&
                Objects.equals(Z, point3D.Z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                '}';
    }
    public Point3D subtract(Point3D a) {
        return new Point3D
                (this.X._coord-a.X._coord,this.Y._coord-a.Y._coord ,this.Z._coord-a.Z._coord);
    }


    public Point3D add (Point3D b) {
        return new Point3D(this.X._coord+b.X._coord,this.Y._coord+b.Y._coord ,this.Z._coord+b.Z._coord);
    }


    public  double distanceSquared(Point3D a )
    {
        return ((this.X._coord-a.X._coord)*(this.X._coord-a.X._coord))
                +((this.Y._coord-a.Y._coord)*(this.Y._coord-a.Y._coord)
                *(this.Y._coord-a.Y._coord)*(this.Z._coord-a.Z._coord));
    }

    public double  distance (Point3D a)
    {
        return Math.sqrt(this.distanceSquared(a));
    }




}




