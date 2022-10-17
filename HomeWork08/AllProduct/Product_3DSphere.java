package HomeWork08.AllProduct;

public class Product_3DSphere extends Product_3D
{
    private double radius;

    @Override
    public double getVolume()
    {
        volume = Math.PI*radius*radius*radius*4/3;
        return volume;
    }

    @Override
    public void process()
    {
        radius = r.nextDouble()*10;
        getVolume();
    }

    @Override
    public void display()
    {
        System.out.println("3DSphere: radius: "+
                radius+" volume: "+volume);
    }
}
