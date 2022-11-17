package com.rotativa.usersapi.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/
import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.GeneratedValue; //Gerando valor aleatório
import javax.persistence.GenerationType; //Estabelecendo estratégia para gerar valores aleatórios
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento", schema = "rotaativa")
public class Pagamento {
    @Id
   /*  @GeneratedValue(strategy = GenerationType.IDENTITY) */
    private int idpagamento;
    private Date dataCompra;
    private Double valor;
    private int quantidadeTicket;

   /*  @ManyToOne
    @JoinColumn(name = "usuario_idusuario" ,nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pagamento")
    private List<TipoPagamento> tiposPagamento; */


    // private int usuario_idusuario
    // PRIMARY KEY (`idpagamento`, `usuario_idusuario`),
    // INDEX `fk_pagamento_TipoPagamento1_idx` (`TipoPagamento_idTipoPagamento` ASC)
    // VISIBLE,
    // INDEX `fk_pagamento_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
    // CONSTRAINT `fk_pagamento_TipoPagamento1`
    // FOREIGN KEY (`TipoPagamento_idTipoPagamento`)
    // REFERENCES `RotaAtiva`.`TipoPagamento` (`idTipoPagamento`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION,
    // CONSTRAINT `fk_pagamento_usuario1`
    // FOREIGN KEY (`usuario_idusuario`)
    // REFERENCES `RotaAtiva`.`usuario` (`idusuario`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION)

    
    public int getIdpagamento() {
        return idpagamento;
    }

    /* public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    } */
    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }
    public Date getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public int getQuantidadeTicket() {
        return quantidadeTicket;
    }

    public void setQuantidadeTicket(int quantidadeTicket) {
        this.quantidadeTicket = quantidadeTicket;
    }

   /*  public List<TipoPagamento> getTiposPagamento() {
        return tiposPagamento;
    }

    public void setTiposPagamento(List<TipoPagamento> tiposPagamento) {
        this.tiposPagamento = tiposPagamento;
    } */
    
    
}
