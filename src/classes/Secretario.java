package classes;

public class Secretario extends  Funcionario{
    private final double  SALARIOBASE = 7000;
    private final double  SALARIOANO = 1000; // salario que o secretário recebe a mais por ano trabalhado.

    public Secretario(String nome, String mesContratacao , String anoContratacao){
        super(nome, mesContratacao, anoContratacao);
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
        return salario(mes, ano)*0.2;
    }

    @Override
    public double salarioBeneficio(String mes, String ano) {
        return salario(mes,ano) + beneficio(mes, ano);
    }



}
