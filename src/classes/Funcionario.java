package classes;

public abstract class Funcionario {
    private String nome;
    private String mesContratacao;
    private String anoContratacao;

    public Funcionario(String nome, String mesContratacao, String anoContratacao){
        this.nome = nome;
        this.mesContratacao = mesContratacao;
        this.anoContratacao = anoContratacao;
    }
    public abstract double salario(String mes, String ano); // salario que todos funcionarios deverao ter com base nos dias trabalhados e beneficios
    public  abstract double beneficio(String mes, String ano);


    public abstract double salarioBeneficio(String mes, String ano); //retorna o salário do funcionário mais os benefícios que ele recebe.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMesContratacao() {
        return mesContratacao;
    }

    public void setMesContratacao(String mesContratacao) {
        this.mesContratacao = mesContratacao;
    }

    public String getAnoContratacao() {
        return anoContratacao;
    }

    public void setAnoContratacao(String anoContratacao) {
        this.anoContratacao = anoContratacao;
    }
}
