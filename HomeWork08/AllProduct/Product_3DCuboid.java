package HomeWork08.AllProduct;

public class Product_3DCuboid extends Product_3D
{
    private double width;
    private double length;
    private double height;

    @Override
    public double getVolume()
    {
        volume=width*length*height;
        return volume;
    }

    @Override
    public void process()
    {
        length=r.nextDouble()*10;
        width=r.nextDouble()*10;
        height=r.nextDouble()*10;
        getVolume();
    }

    @Override
    public void display()
    {
        System.out.println("3DCuboid: length: "+
                length+" width: "+width+" height: "+
                height+" volume: "+volume);
    }
}
