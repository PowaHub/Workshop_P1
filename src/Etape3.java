import exia.ipc.entities.IStep3Strategy;
import exia.ipc.entities.MachineZ;
import exia.ipc.entities.Product;

public class Etape3 implements IStep3Strategy  {

    @Override
    public MachineZ chooseMachine(MachineZ machineZ, MachineZ machineZ1) throws Exception  {
        if(machineZ.isMachineAvailable())
        {
            return machineZ;
        }
       if (machineZ1.isMachineAvailable())
        {
            return machineZ1;
        }

        return null;
    }

    @Override
    public void onMachineRequest(Product product, MachineZ machineZ, MachineZ machineZ1, MachineZ machineZ2) throws Exception {
        new Thread();

        machineZ1.executeJob(product);
        machineZ2.executeJob(product);
        product.makeFinished();
    }
}