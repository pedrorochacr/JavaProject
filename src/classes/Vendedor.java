package classes;

import java.text.ParseException;
import java.util.Calendar;

public class Vendedor extends  Funcionario{
    private double vendas;
    private final double  SALARIOBASE = 12000;
    private final double  SALARIOANO = 1800; // salario que o secretário recebe a mais por ano trabalhado.

    public Vendedor(String nome, String dataContracao, double vendas) throws ParseException {
        super(nome, dataContracao);
        this.vendas = vendas;
    }

    public Vendedor(String nome, String data) throws ParseException {
        super(nome, data);
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
        return  salario()*0.3;
    }

    @Override
    public double salarioBeneficio() {
        return salario() + beneficio();
    }
}
