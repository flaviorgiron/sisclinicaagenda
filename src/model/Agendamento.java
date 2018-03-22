package model;

import java.util.Date;

public class Agendamento {

    private Integer codigo;
    private String agenda;
    private String paciente;
    private String exame;
    private Date data;
    private String hora;
    private String observacao;
    private String secretaria;
    private String pacienteChegou; // OK, ND
    private String pacienteEmAtendimento;// ATEND
    private Double valorPago;
    private String formaPagamento;

    public Agendamento(String agenda, String paciente, String exame, Date data, String hora, String observacao, String secretaria) {
        this.agenda = agenda;
        this.paciente = paciente;
        this.exame = exame;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
        this.secretaria = secretaria;
    }

    public Agendamento(Integer codigo, String agenda, String paciente, String exame, Date data, String hora, String observacao, String secretaria) {
        this.codigo = codigo;
        this.agenda = agenda;
        this.paciente = paciente;
        this.exame = exame;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
        this.secretaria = secretaria;
    }

    public Agendamento() {
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String isPacienteChegou() {
        return pacienteChegou;
    }

    public void setPacienteChegou(String pacienteChegou) {
        this.pacienteChegou = pacienteChegou;
    }

    public String isPacienteEmAtendimento() {
        return pacienteEmAtendimento;
    }

    public void setPacienteEmAtendimento(String pacienteEmAtendimento) {
        this.pacienteEmAtendimento = pacienteEmAtendimento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
