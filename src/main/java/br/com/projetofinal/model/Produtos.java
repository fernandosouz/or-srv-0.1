package br.com.projetofinal.model;


import javax.persistence.Entity;

@Entity
public class Produtos extends AbstractEntity{

    private String name;

    private Integer ponto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPonto() {
        return ponto;
    }

    public void setPonto(Integer ponto) {
        this.ponto = ponto;
    }
}
