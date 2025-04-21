package com.bancodigital.model;

public class Cartao {
    private Long id;
    private double limite;
    private String status;
    private String senha;
    private double fatura;
    private double limiteDiario;

    public Cartao(Long id, double limite, String status, String senha, double fatura, double limiteDiario) {
        this.id = id;
        this.limite = limite;
        this.status = status;
        this.senha = senha;
        this.fatura = fatura;
        this.limiteDiario = limiteDiario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getFatura() {
        return fatura;
    }

    public void setFatura(double fatura) {
        this.fatura = fatura;
    }

    public double getLimiteDiario() {
        return limiteDiario;
    }

    public void setLimiteDiario(double limiteDiario) {
        this.limiteDiario = limiteDiario;
    }
}