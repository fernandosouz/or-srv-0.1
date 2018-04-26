package br.com.projetofinal.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Connections  extends  AbstractEntity implements Comparable<Connections>{
    String connections;

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public List<Connections> findAllByIdOrOrderBy(){
        List<Connections> list = new ArrayList<>();
        return list;
    }

    @Override
    public int compareTo(Connections another) {
        if (this.getId()<another.getId()){
            return -1;
        }else{
            return 1;
        }
    }

}
