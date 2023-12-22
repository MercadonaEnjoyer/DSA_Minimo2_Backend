package edu.upc.dsa;

import edu.upc.dsa.models.Denuncia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

public class DenunciaManagerImp implements DenunciaManager{
    private static DenunciaManager instance;
    protected HashMap<String, Denuncia> lDenuncias  = new HashMap<String, Denuncia>();
    final static Logger logger = Logger.getLogger(DenunciaManagerImp.class);

    public static DenunciaManager getInstance(){
        if(instance == null) instance = new DenunciaManagerImp();
        return instance;
    }
    public void addDenuncia(Denuncia denuncia){
        lDenuncias.put(denuncia.getSender(), denuncia);
    }
    public List<Denuncia> getDenuncias(){
        return new ArrayList<>(this.lDenuncias.values());
    }
}
