package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Secretario extends  Funcionario{
    private final double  SALARIOBASE = 7000;
    private final double  SALARIOANO = 1000; // salario que o secretário recebe a mais por ano trabalhado.

    public Secretario(String nome, String dataContracao) throws ParseException {
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
    public double beneficio() {
        return  salario()*0.2;
    }

    @Override
    public double salarioBeneficio() {
        return salario() + beneficio();
    }
}
