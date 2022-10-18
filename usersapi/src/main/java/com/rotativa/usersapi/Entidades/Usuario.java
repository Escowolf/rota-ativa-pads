package com.rotativa.usersapi.Entidades;
/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/

import java.util.Date;
import java.util.List;

import javax.persistence.Column; // Definindo regras para a coluna
import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.GeneratedValue; //Gerando valor aleatório
import javax.persistence.GenerationType; //Estabelecendo estratégia para gerar valores aleatórios
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="usuario", schema = "rotaativa")
public class Usuario {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;
    private String cpf;
    private String nome;
    private int acessibilidade;
    @Column(nullable=false)
    private String email;
    private String senha;
    private Date datanasc;
    private int ticket;

 /*    @ManyToMany(mappedBy = "usuarios")
    private List<Vagas> Vaga;
     */

    public int getAcessibilidade() {
        return acessibilidade;
    }
    public void setAcessibilidade(int acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    
/*     public List<Vagas> getVaga() {
        return Vaga;
    }
    public void setVaga(List<Vagas> vaga) {
        Vaga = vaga;
    } */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getTicket() {
        return ticket;
    }
    public void setTicket(int ticket) {
        this.ticket = ticket;
    }
    public Date getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
}
