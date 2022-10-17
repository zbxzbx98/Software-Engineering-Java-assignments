package HomeWork08.Other;

import HomeWork08.AllProduct.*;
import HomeWork08.ProductID;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Warehouse
{
    public static Warehouse warehouse;
    private final double totalArea;
    private final double totalVolume;
    private double residualArea;
    private double residualVolume;
    public synchronized double getResidualArea()
    {
        return residualArea;
    }
    public synchronized double getResidualVolume()
    {
        return residualVolume;
    }
    public double getTotalArea()
    {
        return totalArea;
    }
    public double getTotalVolume()
    {
        return totalVolume;
    }
    private final Queue<Product_2D> product_2D_Queue = new ConcurrentLinkedQueue<>();
    private final Queue<Product_3D> product_3D_Queue = new ConcurrentLinkedQueue<>();
    private final Map<ProductID, Producer> producerMap = new HashMap<>();
    public boolean need2D=true,need3D=true;
    public void register(Producer producer)
    {
        producerMap.put(producer.productID,producer);
    }

    public Warehouse(double totalArea, double totalVolume)
    {
        if(warehouse!=null)
            throw new RuntimeException("不能创建多个工厂！");
        warehouse=this;
        this.totalArea = totalArea;
        this.totalVolume = totalVolume;
        residualArea = totalArea;
        residualVolume = totalVolume;
    }

    public synchronized void depositProduct(Product_2D product)
    {
        product_2D_Queue.offer(product);
        residualArea -= product.getArea();
        System.out.println("仓库：放入一个平面产品，剩余面积：" + residualArea);
        this.notifyAll();
    }

    public synchronized void depositProduct(Product_3D product)
    {
        product_3D_Queue.offer(product);
        residualVolume -= product.getVolume();
        System.out.println("仓库：放入一个三维产品，剩余面积：" + residualVolume);
        this.notifyAll();
    }

    public synchronized Product takeOutProduct(ProductID productID) throws InterruptedException
    {
        System.out.println("消费者：请求产品："+productID);
        switch (productID)
        {
            case Rectangle_2D,Triangle_2D,Trapezoidal_2D:
                Product_2D temp2D;
                while (product_2D_Queue.isEmpty())
                {
                    synchronized (producerMap.get(productID))
                    {
                        producerMap.get(productID).notify();
                    }
                    this.wait();
                }
                temp2D = product_2D_Queue.poll();
                residualArea += temp2D.getArea();
                System.out.println("仓库：一个平面产品被拿走，剩余体积：" + residualArea);
                return temp2D;
            case Cuboid_3D,Cylinder_3D,Sphere_3D:
                Product_3D temp3D;
                while (product_3D_Queue.isEmpty())
                {
                    synchronized (producerMap.get(productID))
                    {
                        producerMap.get(productID).notify();
                    }
                    this.wait();
                }
                temp3D = product_3D_Queue.poll();
                residualVolume += temp3D.getVolume();
                System.out.println("仓库：一个三维产品被拿走，剩余体积：" + residualVolume);
                return temp3D;
            default:
                return null;
        }
    }
}
