import exia.ipc.entities.*;

public class Etape1 implements IStep1Strategy
{
    @Override
    public Product onMachineRequest(InputDock dock, MachineX machine) throws Exception {
        //Checker si dock vide
            dock.getAvailableProductsCount();
        //Checker si machine vide

        //Checker si machine already take products
        return dock.accept();
    }
}
