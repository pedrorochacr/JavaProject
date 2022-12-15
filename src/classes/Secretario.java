package classes;

import java.util.Date;

public class Secretario extends  Funcionario{
    private Date data;

    public Secretario(String nome, String dataContracao) {
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
