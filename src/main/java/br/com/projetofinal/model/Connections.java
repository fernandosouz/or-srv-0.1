package br.com.projetofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Connections implements Comparable<Connections>{

    @Id
    public long id;

    String connections;

    Integer x;

    Integer y;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public List<Connections> findAllByIdOrOrderBy(){
        List<Connections> list = new ArrayList<>();
        return list;
    }

    public int compareTo(Connections another) {
        if (this.getId()<another.getId()){
            return -1;
        }else{
            return 1;
        }
    }

    public void updateConnections(Long value){
        String a = this.getConnections();

        a += value.toString() + ",";

        this.setConnections(a);
    }

}
