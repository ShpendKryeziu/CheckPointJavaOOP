package CheckPointJavaOOP;

public class Main {
    public static void main(String[] args) {
        Auto clio = new Auto("Renault", "Clio");
        Auto insignia = new Auto("Opel", "Insignia");
        Auto astra = new Auto("Opel", "Astra");
        Concessionaria breda = new Concessionaria("MonteCarlo");
        breda.addAuto(clio);
        breda.addAuto(insignia);
        breda.addAuto(astra);
        breda.printListino();
        Auto mokka = new Auto("Opel", "Mokka");
        breda.removeAuto(insignia);
        breda.addAuto(mokka);
        breda.printListino();
        System.out.println(breda.searchMake("Opel"));
        System.out.println(breda.getListinoAsMap());
    }
}