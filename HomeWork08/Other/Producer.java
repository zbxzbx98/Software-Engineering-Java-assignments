package HomeWork08.Other;

import HomeWork08.AllProduct.Product;
import HomeWork08.ProductID;

public abstract class Producer extends Thread
{
    public int producerID;
    public ProductID productID;

    public abstract Product build();

}
