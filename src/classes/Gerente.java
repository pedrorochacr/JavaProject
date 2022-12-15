package classes;

public class Gerente extends  Funcionario{

    public Gerente(String nome, String dataContracao) {
        super(nome, dataContracao);
    }

    @Override
    public double salario() {
        return 0;
    }

    @Override
    public double beneficio() { //retorna 0, pois o gerente não possui benefício
        return 0;
    }
}
