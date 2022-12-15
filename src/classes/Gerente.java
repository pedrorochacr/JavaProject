package classes;

import java.text.ParseException;
import java.util.Calendar;

public class Gerente extends  Funcionario{
    private final double  SALARIOBASE = 20000;
    private final double  SALARIOANO = 3000; // salario que o gerente recebe a mais por ano trabalhado.
    public Gerente(String nome, String dataContracao) throws ParseException {
        super(nome, dataContracao);
    }

    @Override
    public double salario() {
        Calendar data = Calendar.getInstance();
        int anoAtual = data.get(Calendar.YEAR);
        double anosTrabalhados = anoAtual - getDataContratacao().getYear();
        return  this.SALARIOBASE + this.SALARIOANO*anosTrabalhados;
    }

    @Override
    public double beneficio() { //retorna 0, pois o gerente não possui benefício
        return 0;
    }

    @Override
    public double salarioBeneficio() {
        return salario()+beneficio();
    }
}
