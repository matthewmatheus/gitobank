package br.com.gitobank.model;

import br.com.gitobank.utils.CriptografiaUtils;
public class Usuario {

    private String email;
    private String senha;


    public Usuario(String email, String senha) {
        super();
        this.email = email;
        setSenha(senha);
    }

    public Usuario() {
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
       try {
           this.senha = CriptografiaUtils.criptografar(senha);
       } catch (Exception e ) {
           e.printStackTrace();
       }
    }
}
