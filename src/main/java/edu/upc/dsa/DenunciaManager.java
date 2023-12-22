package edu.upc.dsa;

import edu.upc.dsa.models.Denuncia;

import java.util.List;

public interface DenunciaManager {
    public void addDenuncia(Denuncia denuncia);
    public List<Denuncia> getDenuncias();
}
