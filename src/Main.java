import backend.Index;
import backend.dados.Storage;
import backend.util.exception.GerenteException;
import backend.util.exception.VendedorException;
import classes.Funcionario;
import classes.Gerente;
import classes.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        String valor;
        System.out.println("Bem Vindo !! Mostrarei alguns testes ...");
        List<Funcionario> recebemBeneficio = new ArrayList<>(); //todos funcionário que recebem beneficio

        List<Vendedor> vendedores = new ArrayList<>();

        for(int i=0; i< storage.getFuncionarios().size(); i++){
            if(storage.getFuncionarios().get(i).getClass() != Gerente.class){ //se não for gerente
                recebemBeneficio.add(storage.getFuncionarios().get(i));
            }
            if(storage.getFuncionarios().get(i).getClass() == Vendedor.class){ //se for vendedor
                vendedores.add((Vendedor) storage.getFuncionarios().get(i));
            }
        }

        try{
            valor = String.format("R$ %.2f",Index.valorTotalMes(storage.getFuncionarios(), "12","2021"));
            System.out.println("Em 12/2021 o valor total recebido pelos funcionários foi de "+valor);

            valor = String.format("R$ %.2f",Index.totalSalarioMes(storage.getFuncionarios(), "08","2017"));
            System.out.println("Em 08/2017 o valor somente de salario recebido pelos funcionários foi de "+valor);

            valor = String.format("R$ %.2f",Index.valorTotalBeneficioMes(recebemBeneficio, "04","2022"));
            System.out.println("Em 04/2022 o valor somente de beneficio recebido pelos funcionários foi de "+valor);

            valor = String.format("R$ %.2f",Index.maiorValorMes(storage.getFuncionarios(), "01","2022").salarioBeneficio("01","2022"));
            System.out.println("Em 01/2022, o  funcionário que recebeu o valor mais alto no mês foi: "
                    +Index.maiorValorMes(storage.getFuncionarios(), "01","2022").getNome()+ ". Valor: "+valor);

            System.out.println("Em 03/2022, o nome do funcionário que recebeu o valor mais alto no mês foi: "+Index.maiorBeneficioMes(recebemBeneficio, "03","2022"));

            System.out.println("Em 03/2022, o vendedor  que mais vendeu  no mês foi: "+Index.melhorVendedorMes(vendedores, "03","2022").getNome());
        }
        catch (GerenteException ex){ //se ocorreu a exceção, na qual foi enviado Gerente no lugar que não podia.
            System.out.println(ex.getMessage());
        }
        catch (VendedorException ex){ //se ocorreu a exceção, na qual foi enviado algum funcionário que não seja Vendedor no lugar que não podia.
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Fim !! Foi um prazer desenvolver esse desafio. ");
    }
}