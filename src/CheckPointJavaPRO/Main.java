package CheckPointJavaPRO;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Ferrari", "Beretta", 350000.0);
        Auto auto2 = new Auto("Lamborghini", "Diablo", 275000.0);
        Auto auto3 = new Auto("Lamborghini", "Gallardo", 265000.0);
        Concessionaria daRicchi = new Concessionaria(Arrays.asList(auto1, auto2, auto3));
        daRicchi.salvaSuFile("./concessionario.csv");
        Concessionaria nuovaConc = new Concessionaria();
        nuovaConc.caricaDaFile("./concessionario.csv");
        System.out.println(nuovaConc.getCatalogo());
        nuovaConc.getCatalogo().stream().filter(auto -> auto.getMarca().equals("Lamborghini")).sorted(Comparator.comparing(o -> o.getPrezzo())).forEach(System.out::println);
    }
}
