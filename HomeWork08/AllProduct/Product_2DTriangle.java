package HomeWork08.AllProduct;

public class Product_2DTriangle extends Product_2D
{
    private double side1;
    private double side2;
    private double side3;

    public double getArea()
    {
        double p =(side1+side2+side3)/2;
        area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return area;
    }

    @Override
    public void process()
    {
        side1=r.nextDouble()*10;
        side2=r.nextDouble()*10;
        side3=r.nextDouble()*10;
        getArea();
    }

    @Override
    public void display()
    {
        System.out.println("2DTriangle:<s1,s2,s3>: <"+side1+
                ", "+side2+", "+side3+"> area: "+area);
    }
}
