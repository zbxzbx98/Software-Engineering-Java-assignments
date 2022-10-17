package HomeWork08.AllProduct;

public class Product_3DCylinder extends Product_3D
{
    private double radius;
    private double height;

    @Override
    public double getVolume()
    {
        volume = Math.PI*radius*radius*height;
        return volume;
    }

    @Override
    public void process()
    {
        radius = r.nextDouble()*10;
        height = r.nextDouble()*10;
        getVolume();
    }

    @Override
    public void display()
    {
        System.out.println("3DCylinder: radius: "+radius+
                " height: "+height+" volume: "+volume);
    }
}
