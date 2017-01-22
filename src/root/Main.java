package root;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlotMachineController(new SlotMachineView(), new SlotMachine()).control();
            }
        });
    }
}
