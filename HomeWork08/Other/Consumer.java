package HomeWork08.Other;

import HomeWork08.AllProduct.Product;

public abstract class Consumer extends Thread
{
    public int consumersID;

    public abstract void consume(Product product);
}
