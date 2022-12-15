package classes;

public class Vendedor extends  Funcionario{
    private double vendas;
    public Vendedor(String nome, String dataContracao) {
        super(nome, dataContracao);
    }

    @Override
    public double salario() {
        return 0;
    }

    @Override
    public double beneficio() {
        return 0;
    }
}
