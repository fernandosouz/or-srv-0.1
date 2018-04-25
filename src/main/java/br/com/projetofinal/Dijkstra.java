package br.com.projetofinal;

import java.util.Stack;

public class Dijkstra {
    //define some constants
    public static final int INF=Integer.MAX_VALUE; //infinity
    public static final int NUM_VERTICES=125;
    public static final int 	P1	=	0;
    public static final int 	P2	=	1;
    public static final int 	P3	=	2;
    public static final int 	P4	=	3;
    public static final int 	P5	=	4;
    public static final int 	P6	=	5;
    public static final int 	P7	=	6;
    public static final int 	P8	=	7;
    public static final int 	P9	=	8;
    public static final int 	P10	=	9;
    public static final int 	P11	=	10;
    public static final int 	P12	=	11;
    public static final int 	P13	=	12;
    public static final int 	P14	=	13;
    public static final int 	P15	=	14;
    public static final int 	P16	=	15;
    public static final int 	P17	=	16;
    public static final int 	P18	=	17;
    public static final int 	P19	=	18;
    public static final int 	P20	=	19;
    public static final int 	P21	=	20;
    public static final int 	P22	=	21;
    public static final int 	P23	=	22;
    public static final int 	P24	=	23;
    public static final int 	P25	=	24;
    public static final int 	P26	=	25;
    public static final int 	P27	=	26;
    public static final int 	P28	=	27;
    public static final int 	P29	=	28;
    public static final int 	P30	=	29;
    public static final int 	P31	=	30;
    public static final int 	P32	=	31;
    public static final int 	P33	=	32;
    public static final int 	P34	=	33;
    public static final int 	P35	=	34;
    public static final int 	P36	=	35;
    public static final int 	P37	=	36;
    public static final int 	P38	=	37;
    public static final int 	P39	=	38;
    public static final int 	P40	=	39;
    public static final int 	P41	=	40;
    public static final int 	P42	=	41;
    public static final int 	P43	=	42;
    public static final int 	P44	=	43;
    public static final int 	P45	=	44;
    public static final int 	P46	=	45;
    public static final int 	P47	=	46;
    public static final int 	P48	=	47;
    public static final int 	P49	=	48;
    public static final int 	P50	=	49;
    public static final int 	P51	=	50;
    public static final int 	P52	=	51;
    public static final int 	P53	=	52;
    public static final int 	P54	=	53;
    public static final int 	P55	=	54;
    public static final int 	P56	=	55;
    public static final int 	P57	=	56;
    public static final int 	P58	=	57;
    public static final int 	P59	=	58;
    public static final int 	P60	=	59;
    public static final int 	P61	=	60;
    public static final int 	P62	=	61;
    public static final int 	P63	=	62;
    public static final int 	P64	=	63;
    public static final int 	P65	=	64;
    public static final int 	P66	=	65;
    public static final int 	P67	=	66;
    public static final int 	P68	=	67;
    public static final int 	P69	=	68;
    public static final int 	P70	=	69;
    public static final int 	P71	=	70;
    public static final int 	P72	=	71;
    public static final int 	P73	=	72;
    public static final int 	P74	=	73;
    public static final int 	P75	=	74;
    public static final int 	P76	=	75;
    public static final int 	P77	=	76;
    public static final int 	P78	=	77;
    public static final int 	P79	=	78;
    public static final int 	P80	=	79;
    public static final int 	P81	=	80;
    public static final int 	P82	=	81;
    public static final int 	P83	=	82;
    public static final int 	P84	=	83;
    public static final int 	P85	=	84;
    public static final int 	P86	=	85;
    public static final int 	P87	=	86;
    public static final int 	P88	=	87;
    public static final int 	P89	=	88;
    public static final int 	P90	=	89;
    public static final int 	P91	=	90;
    public static final int 	P92	=	91;
    public static final int 	P93	=	92;
    public static final int 	P94	=	93;
    public static final int 	P95	=	94;
    public static final int 	P96	=	95;
    public static final int 	P97	=	96;
    public static final int 	P98	=	97;
    public static final int 	P99	=	98;
    public static final int 	P100	=	99;
    public static final int 	P101	=	100;
    public static final int 	P102	=	101;
    public static final int 	P103	=	102;
    public static final int 	P104	=	103;
    public static final int 	P105	=	104;
    public static final int 	P106	=	105;
    public static final int 	P107	=	106;
    public static final int 	P108	=	107;
    public static final int 	P109	=	108;
    public static final int 	P110	=	109;
    public static final int 	P111	=	110;
    public static final int 	P112	=	111;
    public static final int 	P113	=	112;
    public static final int 	P114	=	113;
    public static final int 	P115	=	114;
    public static final int 	P116	=	115;
    public static final int 	P117	=	116;
    public static final int 	P118	=	117;
    public static final int 	P119	=	118;
    public static final int 	P120	=	119;
    public static final int 	P121	=	120;
    public static final int 	P122	=	121;
    public static final int 	P123	=	122;
    public static final int 	P124	=	123;
    public static final int 	P125	=	124;

    public static final int nonexistent=125;
    //start and end vertices
    public static final int FIRST_VERTEX=P1;
    public static final int LAST_VERTEX=P125;
    //list of names of cities, for output
    private String[] name={
                "P1",
                "P2",
                "P3",
                "P4",
                "P5",
                "P6",
                "P7",
                "P8",
                "P9",
                "P10",
                "P11",
                "P12",
                "P13",
                "P14",
                "P15",
                "P16",
                "P17",
                "P18",
                "P19",
                "P20",
                "P21",
                "P22",
                "P23",
                "P24",
                "P25",
                "P26",
                "P27",
                "P28",
                "P29",
                "P30",
                "P31",
                "P32",
                "P33",
                "P34",
                "P35",
                "P36",
                "P37",
                "P38",
                "P39",
                "P40",
                "P41",
                "P42",
                "P43",
                "P44",
                "P45",
                "P46",
                "P47",
                "P48",
                "P49",
                "P50",
                "P51",
                "P52",
                "P53",
                "P54",
                "P55",
                "P56",
                "P57",
                "P58",
                "P59",
                "P60",
                "P61",
                "P62",
                "P63",
                "P64",
                "P65",
                "P66",
                "P67",
                "P68",
                "P69",
                "P70",
                "P71",
                "P72",
                "P73",
                "P74",
                "P75",
                "P76",
                "P77",
                "P78",
                "P79",
                "P80",
                "P81",
                "P82",
                "P83",
                "P84",
                "P85",
                "P86",
                "P87",
                "P88",
                "P89",
                "P90",
                "P91",
                "P92",
                "P93",
                "P94",
                "P95",
                "P96",
                "P97",
                "P98",
                "P99",
                "P100",
                "P101",
                "P102",
                "P103",
                "P104",
                "P105",
                "P106",
                "P107",
                "P108",
                "P109",
                "P110",
                "P111",
                "P112",
                "P113",
                "P114",
                "P115",
                "P116",
                "P117",
                "P118",
                "P119",
                "P120",
                "P121",
                "P122",
                "P123",
                "P124",
                "P125",
    };

    /*** Dijkstra's Algorithm starts here ***/
    int[] distance=new int[NUM_VERTICES];			//vetor de distancias recebe 8 	:int
    boolean[] tight=new boolean[NUM_VERTICES];		//vetor de boolean recebe 8		:boolean
    int[] predecessor=new int[NUM_VERTICES];		//predecessor recebe 8 			:int

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
    public void dijkstra(int s, Array a){
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
    public StringBuilder printShortestPath(int begin, int end){
        Array a = new Array();
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


    public Dijkstra(){ return ; }
}