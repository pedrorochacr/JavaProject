package classes;

import backend.util.Venda;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends  Funcionario{
    List<Venda> vendas = new ArrayList<Venda>(); // cada vendedor possui uma lista de vendas
    private final double  SALARIOBASE = 12000;
    private final double  SALARIOANO = 1800; // salario que o funcionário recebe a mais por ano trabalhado.

    public Vendedor(String nome, String mes, String ano, List<Venda> vendas) {
        super(nome, mes, ano);
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }


    public double vendasData(String mes, String ano){ //retorna o valor vendido pelo vendedor na data passada como parâmetro
        double valor =0;
        for(int i=0; i<vendas.size();i++){
            if(this.vendas.get(i).getMesVenda().equals(mes) && this.vendas.get(i).getAnoVenda().equals(ano)){ //encontra o mes e o ano, no qual o funcionário fez a venda
                valor = this.vendas.get(i).getValorVenda();
            }
        }
        return valor;
    }

    @Override
    public double salario(String mes, String ano) {
        int mesParam = Integer.parseInt(mes);
        int anoParam = Integer.parseInt(ano);
        int anoContratacao = Integer.parseInt(this.getAnoContratacao());
        int mesContratacao = Integer.parseInt(this.getMesContratacao()) ;
        int anosTrabalhados = anoParam - anoContratacao;
        if(anosTrabalhados == 1){
            if(mesContratacao<mesParam){ //se for 1, deve verificar o mes, pois ainda não pode ter completado um ano
                anosTrabalhados=0;
            }
        }
        else if(anosTrabalhados > 1){ //se for 1, deve verificar o mes, pois pode não ter completado os anos informados.
            if(mesParam<mesContratacao){
                anosTrabalhados--;
            }
        }
        return this.SALARIOBASE+this.SALARIOANO*anosTrabalhados;

    }

    @Override
    public double beneficio(String mes, String ano) {
        int mesParam = Integer.parseInt(mes);
        double valor = 0;
        valor = vendasData(mes, ano)*0.3;

        return  valor;
    }

    @Override
    public double salarioBeneficio(String mes, String ano) {
        return salario(mes,ano) + beneficio(mes, ano);
    }
}
