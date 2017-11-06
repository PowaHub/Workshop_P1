import exia.ipc.entities.*;

public class Etape1 implements IStep1Strategy
{
    @Override
    public Product onMachineRequest(InputDock inputDock, MachineX machineX) throws Exception {
        if (inputDock.isProductAvailable()) {
            return machineX.executeWork();
        }
        return inputDock.accept();
    }
}
