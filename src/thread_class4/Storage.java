package thread_class4;

import java.lang.reflect.Member;

public class Storage {
    public int mutex = 0;
    public Product[] products = new Product[10];

    //synchronize互斥，该函数只能被一个线程占用
    public synchronized void push(Product product){

        while(mutex == products.length){
            System.out.println("仓库已满，请生产者等待");
            try {
                wait();
            }catch (InterruptedException e){

                products[mutex] = product;
                mutex++;
                System.out.println(Thread.currentThread().getName()+"生产了产品"+product.getId());
                //
                System.out.println("唤醒其余等待的生产者");
                notifyAll();
                e.printStackTrace();
            }
        }
        //

    }

    public synchronized Product pop(){

        while(mutex == 0){
            System.out.println("仓库为空，请消费者等待生产");
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
            --mutex;
            Product popProduct = products[mutex];
            products[mutex] = null;
            System.out.println(Thread.currentThread().getName()+"消费了产品"+popProduct.getId());
            //
            System.out.println("唤醒其余等待的消费者");
            notifyAll();
            //

            return  popProduct;
    }
}
