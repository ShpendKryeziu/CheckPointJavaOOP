package CheckPointJavaOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Concessionaria {
    private String nomeConcessionaria;
    private List<Auto> listinoAuto = new ArrayList<>();

    public Concessionaria(String nome) {
        setNomeConcessionaria(nome);
    }

    public String getNomeConcessionaria() {
        return nomeConcessionaria;
    }

    public void setNomeConcessionaria(String nomeConcessionaria) {
        this.nomeConcessionaria = nomeConcessionaria;
    }

    public List<Auto> getListinoAuto() {
        return listinoAuto;
    }

    public void setListinoAuto(List<Auto> listinoAuto) {
        this.listinoAuto = listinoAuto;
    }

    public void printListino() {
        for (Auto item : listinoAuto) {
            System.out.println(item.getMarca() + " - " + item.getModello());
        }
    }

    public void addAuto(Auto auto) {
        listinoAuto.add(auto);
    }

    public void removeAuto(Auto auto) {
        listinoAuto.remove(auto);
    }

    public List<Auto> searchMake(String make) {
        List<Auto> searchResults = new ArrayList<>();
        for (Auto auto : listinoAuto) {
            if (auto.getMarca().contains(make)) {
                searchResults.add(auto);
            }
        }
        return searchResults;
    }

    public Map<String, Integer> getListinoAsMap() {
        Map<String, Integer> listinoAsMap = new HashMap<>();
        for (Auto item : listinoAuto) {
            if (!listinoAsMap.containsKey(item.getMarca())) {
                listinoAsMap.put(item.getMarca(), 1);
            } else {
                listinoAsMap.put(item.getMarca(), listinoAsMap.get(item.getMarca()) + 1);
            }
        }
        return listinoAsMap;
    }
}