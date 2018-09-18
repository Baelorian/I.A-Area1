package buscas;

import java.util.Stack;
import nos.No;

public class BuscaEmProfundidade  {
    
    private Stack<No> pilhaNos;
    private String textoResposta;
    
    private int valorBusca;
    
    public BuscaEmProfundidade(int valorBusca){
        this.pilhaNos = new Stack<>();
        
        this.valorBusca = valorBusca;
        
    }
    
    public boolean isResultadoBusca(No no){
        /* Utiliza-se esse tipo de return, pois utilizando o if,
           foi identificado que cairia em uma Busca em Largura.
        */
        return no.getValor() == valorBusca;
    }
    public boolean  buscarResultado(No no) {
        this.pilhaNos.add(no);
        if (isResultadoBusca(no)){
            // exibir o caminho
          //  exibirResultadoPai(no);
          obterResultadoViaPilha();
            return true;
        }else 
        // NO NOSSO CASO TERIA QUE INCLUIR O BAIXO E CIMA, CORRETO? 
        /*OBS: removi o romover dos nós, e estou deixnando ele buscar na arvores toda
               analisa ai e vê se teria como implementar no nosso 
               acredito que sim, mas no caso da PilhaNos, teria que ser o Arvore!
            
            */ 
        {
            // Expandir os proximos nós da esquerda -> direita
            if(no.getNoEsquerda() != null && this.buscarResultado(no.getNoEsquerda())){ 
            // Tem o nó a esquerda
            return true;
            } 
            if (no.getNoDireita() != null && this.buscarResultado(no.getNoDireita())){
                return true;
            }
        }
       // this.pilhaNos.pop(); // Se ele passou pelas condições e não encontrou, remove
        return false;
    }
    
    private void obterResultadoViaPilha(){
        String retorno = "";
        
        while(this.pilhaNos.size() > 0){
            retorno = this.pilhaNos.pop().getValor() + " " + retorno;
        
        }
        this.textoResposta = retorno;
    }

    
    private void obterResultadoPai(No no){
        String retorno = "";
        
        No noValor = no;
        
        retorno += noValor.getValor();
        
        while(noValor.getNoPai() != null){
            noValor = noValor.getNoPai();
            retorno = noValor.getValor() + " " + retorno;
            }
        this.textoResposta = retorno;
        
        }
    
    public void exibirTextoResultado(){
        if(this.textoResposta != null){
            System.out.println("O Caminho Percorrido será:" + this.textoResposta);
        }else
            System.out.println("O Valor " + this.valorBusca + " não foi encontrado");
    }
}

