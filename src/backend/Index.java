package backend;


import backend.util.exception.GerenteException;
import backend.util.exception.VendedorException;
import classes.Funcionario;
import classes.Gerente;
import classes.Vendedor;

import java.util.List;

public class Index { //classe que realiza o tratamento dos dados.
    public static double totalSalarioMes(List<Funcionario> funcionarios, String mes, String ano ){

        double total=0;
        for(int i=0; i<funcionarios.size(); i++){
            if(contratado(funcionarios.get(i), mes, ano)){ //se estiver contrado, o valor do salario daquele funcionario é somado.
                total +=funcionarios.get(i).salario(mes,ano);
            }
        }
        return total;
    }
    public static double valorTotalMes(List<Funcionario> funcionarios, String mes, String ano ){
        double total=0;
        for(int i=0; i<funcionarios.size(); i++){
            if(contratado(funcionarios.get(i), mes, ano)){ //se estiver contrado, o valor do salario total daquele funcionario é somado.
                total +=funcionarios.get(i).salarioBeneficio(mes,ano);
            }
        }
        return total;
    }
    public static double valorTotalBeneficioMes(List<Funcionario> funcionarios, String mes, String ano ) throws GerenteException {
        double total=0;
        for(int i=0; i<funcionarios.size(); i++){
            if(funcionarios.get(i).getClass() == Gerente.class){ //se for gerente
                throw new GerenteException("Deve ser enviado apenas funcionarios que recebem Benefícios!");
            }
            if(contratado(funcionarios.get(i), mes, ano)){ //se estiver contrado, o valor do beneficio daquele funcionario é somado.
                total +=funcionarios.get(i).beneficio(mes,ano);
            }
        }
        return total;
    }
    public static Funcionario maiorValorMes(List<Funcionario> funcionarios, String mes, String ano ){
        double maior = funcionarios.get(0).salarioBeneficio(mes, ano);
        Funcionario melhorFuncionario = funcionarios.get(0);
        for(Funcionario funcionario: funcionarios){
            if(maior<funcionario.salarioBeneficio(mes, ano) ){
                maior = funcionario.salarioBeneficio(mes, ano);
                melhorFuncionario = funcionario;
            }
        }
        return melhorFuncionario;
    }
    public static String maiorBeneficioMes(List<Funcionario> funcionarios, String mes, String ano ) throws GerenteException{
        double maior = funcionarios.get(0).beneficio(mes, ano);
        String nomeFuncionario = funcionarios.get(0).getNome();
        for(Funcionario funcionario: funcionarios){
            if(funcionario.getClass() == Gerente.class){ //se for gerente
                throw new GerenteException("Deve ser enviado apenas funcionarios que recebem Benefícios!");
            }
            if(maior<funcionario.beneficio(mes, ano) ){
                maior = funcionario.beneficio(mes, ano);
                nomeFuncionario = funcionario.getNome();
            }
        }
        return nomeFuncionario;
    }
    public  static Vendedor melhorVendedorMes(List<Vendedor> funcionarios, String mes, String ano ) throws VendedorException {

        double maior = funcionarios.get(0).vendasData(mes, ano);
        Vendedor melhorVendedor = funcionarios.get(0);
        for(int i=0; i<funcionarios.size();i++){
            if(funcionarios.get(i).getClass() != Vendedor.class){ //se não for vendedor
                throw new VendedorException("Deve ser enviado apenas Vendedores!");
            }
            if(maior < funcionarios.get(i).vendasData(mes, ano)){ //encontra o mes e o ano, no qual o funcionário fez a venda
                maior = funcionarios.get(i).vendasData(mes, ano);
                melhorVendedor = funcionarios.get(i);
            }
        }



        return melhorVendedor;
    }
    private static boolean contratado(Funcionario funcionario, String mes, String ano){ // verifica se o funcionário esta contratado na data informada.
        int mesContratacao = Integer.parseInt(funcionario.getMesContratacao());
        int anoContratacao = Integer.parseInt(funcionario.getAnoContratacao());
        int mesParam = Integer.parseInt(mes);
        int anoParam = Integer.parseInt(ano);

        if(anoContratacao<anoParam){ //se o ano de contratacao for menor que o ano passado como parametro, o funcionario estava contratado na data.
            return true;
        }
        else if(anoContratacao == anoParam){ //se o ano de contratacao for igual ao ano passado como parametro, deve-se verificar o mes de contratacao.
            return  true;
        }
        return  false; //se não for nenhuma das condicionais, não esta contratado na data passada como parametro
    }


}
