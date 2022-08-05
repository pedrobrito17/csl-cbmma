package br.gov.ma.ssp.cbm.csl.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="bombeiro_militar")
public class BombeiroMilitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String nomeCompleto;

    @Column
    @NotNull
    private String numIdFuncional;

    @Column
    @NotNull
    private String matricula;

    @Column
    @NotNull
    private String cargo;

    @Column
    @NotNull
    private String quadro;

    @Column
    @NotNull
    private String nomeGuerra;

    @Column
    @NotNull
    private String localTrabalho;    
    
    @Column
    @NotNull
    private String municipioUnidade;

    @Column
    @NotNull
    private String celular;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String senha;

    @Column
    private int ativo = 0;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "bombeiro_role", joinColumns = @JoinColumn(name = "bombeiro_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumIdFuncional() {
        return this.numIdFuncional;
    }

    public void setNumIdFuncional(String numIdFuncional) {
        this.numIdFuncional = numIdFuncional;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getQuadro() {
        return this.quadro;
    }

    public void setQuadro(String quadro) {
        this.quadro = quadro;
    }

    public String getNomeGuerra() {
        return this.nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public String getLocalTrabalho() {
        return this.localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivo() {
        return this.ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getMunicipioUnidade(){
        return this.municipioUnidade;
    }

    public void setMunicipioUnidade(String municipioUnidade){
        this.municipioUnidade = municipioUnidade;
    }

}