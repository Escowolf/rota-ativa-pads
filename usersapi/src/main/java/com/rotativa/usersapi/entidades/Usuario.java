package com.rotativa.usersapi.entidades;
/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/

import java.util.Date;
import java.util.List;

import javax.persistence.Column; // Definindo regras para a coluna
import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.GeneratedValue; //Gerando valor aleatório
import javax.persistence.GenerationType; //Estabelecendo estratégia para gerar valores aleatórios
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="usuario", schema = "rotaativa")
public class Usuario {
    @Id 
    /* @GeneratedValue(strategy = GenerationType.IDENTITY) */
    private int idusuario;
    private String cpf;
    private String nome;
    private int acessibilidade;
    @Column(nullable=false)
    private String email;
    private String senha;
    private Date datanasc;
    private int ticket;

  /*   @OneToMany
    @JoinTable(name = "usuario_telefone",
    joinColumns = @JoinColumn (name ="usuario_id"),
    inverseJoinColumns = @JoinColumn(name ="telefone_id"))
    private List<Telefone> telefone; */

  /*   @OneToMany(mappedBy = "usuario")
    private List<Pagamento> pagamento; */
    

 /*    @ManyToMany(mappedBy = "usuarios")
    private List<Vagas> Vaga; */
    

   /*  public List<Pagamento> getPagamento() {
        return pagamento;
    }
    public void setPagamento(List<Pagamento> pagamento) {
        this.pagamento = pagamento;
    } */
    /* public List<Telefone> getTelefone() {
        return telefone;
    }
    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    } */
    public int getAcessibilidade() {
        return acessibilidade;
    }
    public void setAcessibilidade(int acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    
  /*   public List<Vagas> getVaga() {
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
