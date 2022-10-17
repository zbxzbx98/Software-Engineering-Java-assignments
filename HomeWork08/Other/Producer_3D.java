package HomeWork08.Other;

import HomeWork08.AllProduct.*;
import HomeWork08.ProductID;

public class Producer_3D extends Producer
{
    public Producer_3D(int producerID,ProductID productID)
    {
        this.producerID=producerID;
        this.productID = productID;
    }

    @Override
    public Product_3D build()
    {
        Product_3D temp;
        switch (productID)
        {
            case Cuboid_3D:
                temp=new Product_3DCuboid();
                break;
            case Cylinder_3D:
                temp=new Product_3DCylinder();
                break;
            case Sphere_3D:
                temp=new Product_3DSphere();
                break;
            default:
                return null;
        }
        temp.process();
        try
        {
            sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("3D生产者："+productID+"生产完成！");
        return temp;
    }

    @Override
    public void run()
    {
        while (Warehouse.warehouse.need3D)
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
            System.out.println("3D生产者：生产产品："+productID);
            Warehouse.warehouse.depositProduct(build());

        }
    }
}
