package br.com.projetofinal.model;

import javax.persistence.Entity;

@Entity
public class Connections  extends  AbstractEntity{
    String connections;

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

}
