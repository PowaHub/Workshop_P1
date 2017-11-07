import exia.ipc.entities.IStep2Strategy;
import exia.ipc.entities.MachineX;
import exia.ipc.entities.MachineY;

import java.util.concurrent.Semaphore;

public class Etape2 implements IStep2Strategy {
    private final Semaphore available = new Semaphore(2,true);
    @Override
    public void onMachineRequest(MachineX machineX, MachineY machineY) throws Exception {
        available.acquire();
    }
    @Override
    public void onMachineExecute(MachineX machineX, MachineY machineY) throws Exception {

        machineY.executeJob();
        available.release();
    }
}
