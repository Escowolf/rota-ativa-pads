package com.rotativa.usersapi.entidades;

/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.Column; // Definindo regras para a coluna
import javax.persistence.GeneratedValue; //Gerando valor aleatório
import javax.persistence.GenerationType; //Estabelecendo estratégia para gerar valores aleatórios
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vaga", schema = "rotaativa")
public class Vagas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvaga;
    @Column(nullable = false)
    private String rua_avenida;
    private String bairro;
    private Date entrada;
    private Date saida;
  
/*     @ManyToMany
    @JoinTable(name = "Vaga_Usuario", 
      joinColumns = @JoinColumn(name = "idvaga"), 
      inverseJoinColumns = @JoinColumn(name = "idusuario"))
         */
 /*    private List<Usuario> usuarios; */
    // `acessibilidade` TINYINT(1) NOT NULL,
    
    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public int getIdvaga() {
        return idvaga;
    }

    public void setIdvaga(int idvaga) {
        this.idvaga = idvaga;
    }

    public String getRua_avenida() {
        return rua_avenida;
    }

    public void setRua_avenida(String rua_avenida) {
        this.rua_avenida = rua_avenida;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

/*     public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    } */
}
