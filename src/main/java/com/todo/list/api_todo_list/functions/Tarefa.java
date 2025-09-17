package com.todo.list.api_todo_list.functions;

import jakarta.persistence.*;

@Entity
@Table(name="Tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private boolean status;
    private String concluido;
    private int prioridade;
    private String tipodePrio;

    public Tarefa(String nome, String descricao, String tipodePrio) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = false;
        this.concluido="Não concluido";
        this.tipodePrio = tipodePrio;

    }
    public Tarefa() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrioridade() {
        if (tipodePrio.equals("Alta")){
            return 1;
        } else if (tipodePrio.equals("Média")) {
            return 2;
        } else if (tipodePrio.equals("Baixa")) {
            return 3;
        } else {
            return 0;
        }
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getTipodePrio() {
        return tipodePrio;
    }

    public String getConcluido() {
        if (!status){
            return "Não concluido";
        }else
            return "Concluido";
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        return "[Prioridade " + tipodePrio + "] " + nome + " - " + descricao+" status: "+ getConcluido();
    }

}
