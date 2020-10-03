package kpi.trspo.client;


import kpi.trspo.client.controllers.*;

public class App
{
    public static void main( String[] args ) {
        try{
            WorkerTest workerTest = new WorkerTest();
            ClientTest clientTest = new ClientTest();
            MaterialTest materialTest = new MaterialTest();
            StorageTest storageTest = new StorageTest();
            PriceTest priceTest = new PriceTest();
            ProductionTest productionTest = new ProductionTest();
            OrderTest orderTest = new OrderTest();

            workerTest.testService();
            clientTest.testService();
            materialTest.testService();
            storageTest.testService();
            priceTest.testService();
            productionTest.testService();
            orderTest.testService();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
