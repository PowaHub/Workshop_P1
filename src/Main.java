import exia.ipc.entities.IStep1Strategy;
import exia.ipc.entities.IStep2Strategy;
import exia.ipc.entities.IStep3Strategy;
import exia.ipc.entities.PrositIPC;

public class Main {
    public static void main(String[] args){
        // On indique les classes des différents exercices
        PrositIPC.Step1 = new Etape1();
        //PrositIPC.Step2 = new Etape2();
        //PrositIPC.Step3 = new Etape3();

        //On lance l'application
        PrositIPC.start();
    }
}