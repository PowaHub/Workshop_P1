import exia.ipc.entities.*;

public class Etape1 implements IStep1Strategy
{
    @Override
    public synchronized Product onMachineRequest(InputDock inputDock, MachineX machineX) throws Exception {

        return inputDock.accept();
    }
}
