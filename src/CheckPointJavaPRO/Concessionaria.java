package CheckPointJavaPRO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Concessionaria {
    private List<Auto> catalogo;

    public Concessionaria() {
        this.catalogo = new ArrayList<>();
    }
    public Concessionaria (List<Auto> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Auto> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Auto> catalogo) {
        this.catalogo = catalogo;
    }

    public void salvaSuFile (String path) {
        Path percorso = Path.of(path);
        StringBuilder buildoStringa = new StringBuilder();
        buildoStringa.append("Marca;Modello;Prezzo");
        for (Auto auto : catalogo) {
            buildoStringa.append("\n").append(auto.getMarca()).append(";").append(auto.getModello())
                    .append(";").append(auto.getPrezzo());
        }
        try {
            Files.writeString(percorso, buildoStringa.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaDaFile (String path) {
        Path percorso = Path.of(path);
        String fileInStringa = null;
        try {
            fileInStringa = Files.readString(percorso);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Auto> nuovoCatalogo = new ArrayList<>();
        String[] righeFile = fileInStringa.split("\n");
        for (int i = 1; i < righeFile.length; i++) {
            String[] celleFile = righeFile[i].split(";");
            Auto auto = new Auto(celleFile[0], celleFile[1], Double.valueOf(celleFile[2]));
            nuovoCatalogo.add(auto);
        }
        this.catalogo = nuovoCatalogo;
    }
}
