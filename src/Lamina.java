import java.util.ArrayList;
import java.util.List;

public class Lamina {
    private Integer espessura;
    private Integer valorReducao1;
    private Integer valorReducao2;
    private Integer valorReducao3;
    private Integer posicao = 0;
    private List<Lamina> tabela = new ArrayList<>();
    private int custo = 0;
    public Lamina(int espessura, Integer valor1, Integer valor2, Integer valor3){
        this.espessura = espessura;
        this.valorReducao1 = valor1;
        this.valorReducao2 = valor2;
        this.valorReducao3 = valor3;
    }
    public void setTabela(List<Lamina> listaLamina){
        this.tabela = listaLamina;
    }
    public int getEspessura() {
        return espessura;
    }
    public void setCusto( int custo){
        this.custo = custo;
    }
    public Integer getValorReducao1() {
        return valorReducao1;
    }

    public Integer getValorReducao2() {
        return valorReducao2;
    }

    public Integer getValorReducao3() {
        return valorReducao3;
    }
    public void reduzirLamina(int milimetro){
        System.gc();

        if(this.posicao < this.tabela.size()){
        if(milimetro == 1){
            this.custo += this.valorReducao1;
            this.espessura -= 1;
        }else if(milimetro == 2){
            if(this.tabela.get(posicao).getValorReducao2() == null){
                this.custo +=this.tabela.get(posicao).getValorReducao2();
                this.espessura -= 1;
            }
            this.custo += this.valorReducao2;
            this.espessura -= 2;
        }else {
            if (this.tabela.get(posicao).getValorReducao3() == null) {
                if (this.tabela.get(posicao).getValorReducao2() == null) {
                    this.custo += this.tabela.get(posicao).getValorReducao1();
                    this.espessura -= 1;

                } else {
                    this.custo += this.tabela.get(posicao).getValorReducao2();
                    this.espessura -= 2;
                }
            }else{
                this.custo += this.tabela.get(posicao).getValorReducao3();
                this.espessura -= 3;
            }
        }

            this.valorReducao1 = this.tabela.get(posicao).getValorReducao1();
            this.valorReducao2 = this.tabela.get(posicao).getValorReducao2();
            this.valorReducao3 = this.tabela.get(posicao).getValorReducao3();
            this.posicao += milimetro;
        }
    }
    public int getCusto(){
        return custo;
    }
    public Lamina clone(){
        return new Lamina(espessura, valorReducao1, valorReducao2, valorReducao3);
    }
}
