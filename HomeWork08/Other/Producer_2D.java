package HomeWork08.Other;

import HomeWork08.AllProduct.*;
import HomeWork08.ProductID;

public class Producer_2D extends Producer
{
    public Producer_2D(int producerID,ProductID productID)
    {
        this.producerID=producerID;
        this.productID = productID;
    }

    @Override
    public Product_2D build()
    {
        Product_2D temp;
        switch (productID)
        {
            case Rectangle_2D:
                temp=new Product_2DRectangle();
                break;
            case Triangle_2D:
                temp=new Product_2DTriangle();
                break;
            case Trapezoidal_2D:
                temp=new Product_2DTrapezoidal();
                break;
            default:
                return null;
        }
        temp.process();
        try
        {
            sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("2D生产者："+productID+"生产完成！");
        return temp;
    }

    @Override
    public void run()
    {
        while (Warehouse.warehouse.need2D)
        {
            try
            {
                synchronized (this)
                {
                    wait();
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("2D生产者：生产产品："+productID);
            Warehouse.warehouse.depositProduct(build());
        }
    }
}
