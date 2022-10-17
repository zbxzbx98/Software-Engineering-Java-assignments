package HomeWork08.AllProduct;

public class Product_2DTrapezoidal extends Product_2D
{
    private double bottomLength;
    private double upLength;
    private double height;
    /**
     * 上底起点相对下底起点的向右偏移量，用于唯一确定一个梯形
     */
    private double upOffset;

    @Override
    public double getArea()
    {
        area =(bottomLength+upLength)*height/2;
        return area;
    }

    @Override
    public void process()
    {
        bottomLength=r.nextDouble()*10;
        upLength=r.nextDouble()*10;
        height=r.nextDouble()*10;
        upOffset=r.nextDouble()*5;
        getArea();
    }

    @Override
    public void display()
    {
        System.out.println("2DTrapezoidal: bottom: "+
                bottomLength+" up: "+upLength+" height: "+
                height+" upOffset: "+upOffset);
    }
}
