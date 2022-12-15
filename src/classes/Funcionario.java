package classes;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class Funcionario {
    private String nome;
    private LocalDate dataContratacao;

    public Funcionario(String nome, String data) throws ParseException {
        this.nome = nome;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
        this.dataContratacao = LocalDate.parse(data, formato);
    }
    public abstract double salario(); // salario que todos funcionarios deverao ter com base nos dias trabalhados e beneficios
    public  abstract double beneficio();

    public abstract double salarioBeneficio(); //retorna o salário do funcionário mais os benefícios que ele recebe.
    public String getNome() {
        return nome;
    }
    public  void setNome(String nome){
        this.nome = nome;
    }

    protected LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
        this.dataContratacao = LocalDate.parse(data, formato);
    }
}
