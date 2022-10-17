package HomeWork08;

import HomeWork08.Other.*;


public class FactoryTest
{
    public static void main(String[] args)
    {
        Warehouse warehouse =new Warehouse(1000,10000);
        Producer[] allProducers =
                {new Producer_2D(1,ProductID.Rectangle_2D),
                 new Producer_2D(2,ProductID.Triangle_2D),
                 new Producer_2D(3,ProductID.Trapezoidal_2D),
                 new Producer_3D(4,ProductID.Sphere_3D),
                 new Producer_3D(5,ProductID.Cuboid_3D),
                 new Producer_3D(6,ProductID.Cylinder_3D),};
        for (Producer producer : allProducers)
        {
            warehouse.register(producer);
            producer.start();
        }
        Consumer_2D consumer_2D = new Consumer_2D(1,
                new ProductID[]{
                   ProductID.Rectangle_2D,ProductID.Triangle_2D,ProductID.Rectangle_2D,
                   ProductID.Trapezoidal_2D,ProductID.Trapezoidal_2D,ProductID.Rectangle_2D});
        Consumer_3D consumer_3D = new Consumer_3D(2,
                new ProductID[]{ProductID.Cylinder_3D,ProductID.Sphere_3D,ProductID.Cuboid_3D,
                        ProductID.Cuboid_3D,ProductID.Sphere_3D,ProductID.Cylinder_3D});
        consumer_2D.start();
        consumer_3D.start();
    }
}
