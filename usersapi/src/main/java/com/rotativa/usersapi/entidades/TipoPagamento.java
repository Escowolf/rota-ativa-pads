package com.rotativa.usersapi.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipopagamento", schema = "rotaativa")
public class TipoPagamento {
    @Id 
   /*  @GeneratedValue(strategy = GenerationType.IDENTITY) */
    private int idTipoPagamento;
    private String TipoPagamento;
    private String DescPagamento;

   /*   @ManyToOne
    @JoinColumn(nullable = false,unique = false)
    private Usuario usuario;  */

    /* @ManyToOne
    @JoinColumn(name = "pagamento_idpagamento",nullable = false)
    private Pagamento pagamento; */
    
  
    
   /*  public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    } */
    
   /*  public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    } */
    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }
    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }
    public String getTipoPagamento() {
        return TipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        TipoPagamento = tipoPagamento;
    }
    public String getDescPagamento() {
        return DescPagamento;
    }
    public void setDescPagamento(String descPagamento) {
        DescPagamento = descPagamento;
    }
}
