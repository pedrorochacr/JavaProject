package backend.util;

public class Venda {
    private String mesVenda;
    private String anoVenda;
    private double valorVenda;

    public Venda(String anoVenda, String mesVenda, double valorVenda) {
        this.anoVenda = anoVenda;
        this.mesVenda = mesVenda;
        this.valorVenda = valorVenda;
    }

    public String getMesVenda() {
        return mesVenda;
    }

    public void setMesVenda(String mesVenda) {
        this.mesVenda = mesVenda;
    }

    public String getAnoVenda() {
        return anoVenda;
    }

    public void setAnoVenda(String anoVenda) {
        this.anoVenda = anoVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
