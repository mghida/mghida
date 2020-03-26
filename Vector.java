package primitives;

import java.util.Objects;

public class Vector extends Point3D {
   protected Point3D Head_Vector;

    public Vector (Coordinate x, Coordinate y,Coordinate z) {
        super(x,y,z);
        Head_Vector = new Point3D(x, y, z);
    }

    public Vector(double x, double y, double z) {
        super(x,y,z);
        Head_Vector = new Point3D(x, y, z);
    }

    public Vector(Point3D a) {
        super(a);
        Head_Vector=new Point3D(a.getX(),a.getY(),a.getY());
    }
    public  Vector (Vector a)
    {
        super(a.Head_Vector.getX(), a.Head_Vector.getY(),a.Head_Vector.getZ());
        //Head_Vector=new Point3D(a.Head_Vector.getX(),a.Head_Vector.getY(),a.Head_Vector.getZ());
    }


    @Override
    public String toString() {
        return "Vector{" +
                "Head_Vector=" + Head_Vector +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vector vector = (Vector) o;
        return Objects.equals(Head_Vector, vector.Head_Vector);
    }


    //we are going to do now cross product between two vector and get back an new vector vertical two vector
    public Vector  crossProduct (Vector b)
    {
        /*we send to ctractor a new vector kinds of double
        c.x= a.y*b.z − a.z*b.y
        c.y = a.z*b.x − a.x*b.z
        c.z = a.x*b.y − a.y*b.x
         */
        Vector temp=new Vector(((this.Head_Vector.getY()._coord*b.Head_Vector.getZ()._coord) -(this.Head_Vector.getZ()._coord*b.Head_Vector.getY()._coord))
                ,((this.Head_Vector.getZ()._coord*b.Head_Vector.getX()._coord) -(this.Head_Vector.getX()._coord*b.Head_Vector.getZ()._coord))
                ,(this.Head_Vector.getX()._coord*b.Head_Vector.getY()._coord)-(this.Head_Vector.getY()._coord*b.Head_Vector.getX()._coord));

        return  temp;
    }
    public double lengthSquared()
    {
        return  ((this.Head_Vector.getX()._coord*this.Head_Vector.getX()._coord)
                +(this.Head_Vector.getY()._coord*this.Head_Vector.getY()._coord)
                +(this.Head_Vector.getZ()._coord*this.Head_Vector.getZ()._coord));
    }
    public  double length()
    {
        return  Math.sqrt(this.lengthSquared());
    }
    public  Vector scale (double multe)
    {
        return new Vector(
                Head_Vector.getX()._coord*multe,
                Head_Vector.getY()._coord*multe,
                Head_Vector.getZ()._coord*multe);
    }
    public double  dotProduct(Vector b)
    {
        return  ((this.Head_Vector.getX()._coord*b.Head_Vector.getX()._coord)
                +(this.Head_Vector.getX()._coord*b.Head_Vector.getX()._coord)
                +(this.Head_Vector.getX()._coord*b.Head_Vector.getX()._coord));
    }
    public Vector normalize()
    {
        double temp =this.length();//the length of this vector
        this.Head_Vector=new Vector(Head_Vector.getX()._coord/length()
                ,Head_Vector.getY()._coord/length(),
                Head_Vector.getZ()._coord/length() );
        return this;
    }
    public Vector  normalized()
    {
        return new Vector (this.normalize());
    }
    public Vector add(Vector a)
    {
        return  new Vector(this.Head_Vector.add(a));
    }
    public Vector  subtract(Vector a)
    {
        return new Vector(this.Head_Vector.subtract(a));

    }
}