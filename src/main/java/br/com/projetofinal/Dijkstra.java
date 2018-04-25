package br.com.projetofinal;
import br.com.projetofinal.repository.ConnectionsRepository;
import static java.lang.Math.toIntExact;
import java.util.Stack;

public class Dijkstra {
    /*Declaração das variáveis usadas*/
    int INF;
    int NUM_VERTICES;
    int nonexistent;
    int FIRST_VERTEX;
    int LAST_VERTEX;
    private String[] name;
    int[] distance;
    boolean[] tight;
    int[] predecessor;
    /*TODO Melhorar os comentários do código para futura manutenção*/
    private int minimalNontight(){
        int j,u;

        //ve qual é o ´roximo que não foi visitado e coloca em j
        for(j=FIRST_VERTEX; j<LAST_VERTEX; j++){
            if(!tight[j])
                break;
        }

        assert(j<=LAST_VERTEX); //se ele é menor que o ultimo
        u=j;
        /* u is now the first vertex with nontight estimate, but maybe not the minimal one. */

        for(j++; j<=LAST_VERTEX; j++)
            if(!tight[j] && distance[j]<distance[u])
                u=j;
        return u;
    }

    private boolean successor(int u, int z, Array a){

        return ((a.readArray(u,z)!=INF) && u!=z);
    }
    //now initialise these arrays
    private void dijkstra(int s, Array a){
        int z,u;
        int i;
        distance[s]=0;										//ditancia no inicial recebe 0

        for(z=FIRST_VERTEX; z<=LAST_VERTEX; z++){			//percorre todos os vertices
            if(z!=s) distance[z]=INF;						//se não for o origem coloca INF na distancia
            tight[z]=false;									//visitado recebe falso
            predecessor[z]=nonexistent;						//antecessor coloca nao existente = 8
        }

        for(i=0; i<NUM_VERTICES; i++){						//percorre todos os vertices
            u=minimalNontight();							//pega o mais curto
            tight[u]=true;									//coloca true em visitado
            if(distance[u]==INF)							//verifica a distancia de i até u
                continue;
            for(z=FIRST_VERTEX; z<=LAST_VERTEX; z++)		//de 0 até 7
                if(successor(u,z, a) /*&& !tight[z]*/ && (distance[u]+ a.readArray(u,z) <distance[z])){ //se tiver caminho(sucessor) e se a distancia de
                    distance[z]=distance[u]+a.readArray(u,z); //we've found a shortcut
                    predecessor[z]=u;
                }
        }
    }

    public StringBuilder printShortestPath(int begin, int end, ConnectionsRepository connections){

        Array a = new Array(connections);
        StringBuilder ret = new StringBuilder();
        ret.append("");
        int origin      = begin - 1;
        int destination = end - 1;
        assert(origin!=nonexistent && destination!=nonexistent);  //assert é um if que deu certo
        dijkstra(origin, a);
        Stack<Integer> st=new Stack<Integer>();

        /*para o destino, roda o que for diferente de origem e a iteração vai para o antecessor*/
        for(int v=destination; v!=origin; v=predecessor[v])
            if(v==nonexistent){
                System.out.println("non-existent (because the graph is not connected).");
                return ret;
            }else{
                st.push(v);
            }
        //no fim coloco a origem, é uma pilha
        st.push(origin);
        int i = 0;
        while(!st.empty()) {
            i = st.pop();
            ret.append(name[i] + ",");
        }
        ret.append("LAST");

        return ret;
    }

    public Dijkstra(ConnectionsRepository connectionsDAO){
        /*Pego o tamanho da entidade Connections (que são os pontos)*/
        int lenght = toIntExact(connectionsDAO.count());

        /*Atribuição de valor às variáveis usadas*/
        this.INF =Integer.MAX_VALUE;
        this.NUM_VERTICES = lenght;
        this.nonexistent = lenght;
        this.FIRST_VERTEX = 0;
        this.LAST_VERTEX = lenght - 1;

        this.distance = new int[NUM_VERTICES];
        this.tight = new boolean[NUM_VERTICES];
        this.predecessor = new int[NUM_VERTICES];

        name = new String[NUM_VERTICES];

        for(int i = 0; i < NUM_VERTICES; i++){
            int k = i + 1;
            String a = "P" + k;
            this.name[i] = a;
        }

    }
}