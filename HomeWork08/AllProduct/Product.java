package HomeWork08.AllProduct;

import java.util.Random;

public abstract class Product
{
    protected String producerName;
    protected int itemID;
    protected Random r = new Random();

    /**
     * 生产产品函数
     */
    public abstract void process();

    /**
     * 消费产品函数
     */
    public abstract void display();
}
