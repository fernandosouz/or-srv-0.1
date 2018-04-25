package br.com.projetofinal;

import br.com.projetofinal.model.Connections;
import br.com.projetofinal.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import static java.lang.Math.toIntExact;

public class Array {

    List<Connections> connectionsList;

    public static final int INF=Integer.MAX_VALUE;

    /*Contrutor seta toda a entidade Connections no List*/
    public Array(ConnectionsRepository connections) {

        /*No construtor eu pego as conexões no banco e jogo na connectionList*/
        List<Connections> list = new ArrayList<>();

        Iterable iterable = connections.findAll();

        /*Pegar o Iterable e transformar em ArrayList*/
        if(iterable instanceof List) {
            list = (List<Connections>) iterable;
        }else{
            for(Object c: iterable) {
                list.add( (Connections) c);
            }
        }

        this.connectionsList = list;
    }

    /*Retorna 1 se no ponto a existir o ponto b*/
    public int readArray(Integer a, Integer b){

        if(a == b)
            return 0;
        /*a chega com a posição no dijskstra então não diminuo pois o get também busca pela posição (que é PONTO-1)*/
        /*b chega com a posição no dijskstra que é um a menos que no banco, por isso somo, para que ele pegue o PONTO correto*/
        b++;
        if(this.connectionsList.get(a).getConnections().contains("," + b + ","))
            return 1;

        return this.INF;
    };
}