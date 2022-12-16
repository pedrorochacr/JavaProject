package classes;

public class Gerente extends  Funcionario{
    private final double  SALARIOBASE = 20000;
    private final double  SALARIOANO = 3000; // salario que o gerente recebe a mais por ano trabalhado.
    public Gerente(String nome, String mes, String ano) {
        super(nome, mes, ano);

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
    public double beneficio(String mes, String ano){ //retorna 0, pois o gerente não possui benefício
        return 0;
    }

    @Override
    public double salarioBeneficio(String mes, String ano) {
        return salario(mes,ano) ;
    }
}
