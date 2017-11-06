import exia.ipc.entities.IStep3Strategy;
import exia.ipc.entities.MachineZ;
import exia.ipc.entities.Product;
import exia.ipc.exceptions.MachineAllreadyUsedException;
import exia.ipc.exceptions.OperationAllreadyDoneException;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Etape3 implements IStep3Strategy{

    final CyclicBarrier gate = new CyclicBarrier(3);


    private int test = 0;
    @Override
    public MachineZ chooseMachine(MachineZ m1, MachineZ m2) throws Exception {
        if(m1.isChainAvailable()) {

            return m1;
        }
        if (m2.isChainAvailable()) {
            return m2;
        }
        while (!m1.isChainAvailable()) {
            Thread.sleep(10);
        }
        return m1;
    }

    @Override
    public void onMachineRequest(Product product, MachineZ machineZ, MachineZ machineZ1, MachineZ machineZ2) throws Exception {
       Thread t1 = new Thread(){
           public void run()
           {
               try {
                   machineZ.executeJob(product);
               } catch (MachineAllreadyUsedException e) {
                   e.printStackTrace();
               } catch (OperationAllreadyDoneException e) {
                   e.printStackTrace();
               }
           }
       };
        Thread t2 = new Thread(){
            public void run()
            {
                try {
                    machineZ.executeJob(product);
                } catch (MachineAllreadyUsedException e) {
                    e.printStackTrace();
                } catch (OperationAllreadyDoneException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3 = new Thread(){
            public void run()
            {
                try {
                    machineZ.executeJob(product);
                } catch (MachineAllreadyUsedException e) {
                    e.printStackTrace();
                } catch (OperationAllreadyDoneException e) {
                    e.printStackTrace();
                }
            }
        };
        /*machineZ.executeJob(product);
        machineZ1.executeJob(product);
        machineZ2.executeJob(product);*/
        /*t.start();
        t1.start();
        t2.start();*/
        //t3.start();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
            product.makeFinished();

    }
}