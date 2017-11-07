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
    public MachineZ chooseMachine(MachineZ target1, MachineZ target2) throws Exception
    {

        if(target1.isChainAvailable()== true && test==0){
            test=1;
            return target1;

        }
        else if (target2.isChainAvailable()==true && test ==1){
            test = 0;
            return target2;
        }


        while (target1.isChainAvailable()==false && target2.isChainAvailable()==false){

        }


        return null;

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
                        machineZ1.executeJob(product);
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
                    machineZ2.executeJob(product);

                } catch (MachineAllreadyUsedException e) {
                    e.printStackTrace();
                } catch (OperationAllreadyDoneException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
            product.makeFinished();

    }
}