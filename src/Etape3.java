import exia.ipc.entities.IStep3Strategy;
import exia.ipc.entities.MachineZ;
import exia.ipc.entities.Product;

public class Etape3 implements IStep3Strategy {

    @Override
    public MachineZ chooseMachine(MachineZ machineZ, MachineZ machineZ1) throws Exception {
        return null;
    }

    @Override
    public void onMachineRequest(Product product, MachineZ machineZ, MachineZ machineZ1, MachineZ machineZ2) throws Exception {

    }
}