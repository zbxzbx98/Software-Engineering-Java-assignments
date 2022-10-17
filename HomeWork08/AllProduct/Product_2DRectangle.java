package HomeWork08.AllProduct;

public class Product_2DRectangle extends Product_2D
{
    private double width;
    private double length;

    @Override
    public double getArea()
    {
        area = length * width;
        return area;
    }

    @Override
    public void process()
    {
        width=r.nextDouble()*10;
        length=r.nextDouble()*10;
        getArea();
    }

    @Override
    public void display()
    {
        System.out.println("2DRectangle: width: "+width+
                " length: "+length+" area: "+area);
    }
}
