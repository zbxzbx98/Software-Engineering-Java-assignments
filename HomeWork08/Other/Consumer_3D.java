package HomeWork08.Other;

import HomeWork08.AllProduct.Product;
import HomeWork08.ProductID;

public class Consumer_3D extends Consumer
{
    public ProductID[] allNeed;

    public Consumer_3D(int consumersID,ProductID[] allNeed)
    {
        this.consumersID=consumersID;
        this.allNeed = allNeed;
    }

    @Override
    public void consume(Product product)
    {
        System.out.println("3D消费者：消费物品：");
        product.display();
    }

    @Override
    public void run()
    {
        for (ProductID product : allNeed)
        {
            try
            {
                Product take = Warehouse.warehouse.takeOutProduct(product);
                sleep(200);
                consume(take);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        Warehouse.warehouse.need3D=false;
    }
}
