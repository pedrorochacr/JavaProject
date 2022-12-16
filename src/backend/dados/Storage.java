package backend.dados;

import backend.util.Venda;
import classes.Funcionario;
import classes.Gerente;
import classes.Secretario;
import classes.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class Storage { //classe que armazena as informações
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Storage(){
            this.funcionarios.add(new Secretario("Jorge Carvalho", "01", "2018"));
            this.funcionarios.add(new Secretario("Maria Souza", "12", "2015"));
            this.funcionarios.add(new Vendedor("Ana Silvia", "12","2021",inicializaVendas("Ana Silvia")));
            this.funcionarios.add(new Vendedor("João Mendes", "12","2021", inicializaVendas("João Mendes")));
            this.funcionarios.add(new Gerente("Juliana Alves", "07","2017"));
            this.funcionarios.add(new Gerente("Bento Albino", "03","2014"));
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
    private List<Venda> inicializaVendas(String nome){ // inicializa as vendas de cada funcionário com base no nome
        List<Venda> vendasFuncionario =new ArrayList<Venda>();
        if(nome.equals("Ana Silvia")){
            vendasFuncionario.add(new Venda("2021","12",5200));
            vendasFuncionario.add(new Venda("2022","01",4000));
            vendasFuncionario.add(new Venda("2022","02",4200));
            vendasFuncionario.add(new Venda("2022","03",5850));
            vendasFuncionario.add(new Venda("2022","04",7000));
        } else { // Joâo Mendes
            vendasFuncionario.add(new Venda("2021","12",3400));
            vendasFuncionario.add(new Venda("2022","01",7700));
            vendasFuncionario.add(new Venda("2022","02",5000));
            vendasFuncionario.add(new Venda("2022","03",5900));
            vendasFuncionario.add(new Venda("2022","04",6500));
        }
        return vendasFuncionario;
    }
}
