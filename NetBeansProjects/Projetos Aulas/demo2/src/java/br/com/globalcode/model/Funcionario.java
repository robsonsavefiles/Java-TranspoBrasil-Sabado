
package br.com.globalcode.model;

public class Funcionario {
    
    private String id;
    private String nome;
    private String sobrenome;
    
    public Funcionario(String id, String nome, String sobrenome) {
        this.setId(id);
        this.setNome(nome);
        this.setSobrenome(sobrenome);
    }
    
    public Funcionario(String id){
        this.setId(id);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public boolean equals(Object obj) {
        if(obj instanceof Funcionario){
            Funcionario fun = (Funcionario)obj;
            if(fun.getId()==this.getId()){
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Integer.parseInt(this.getId());
    }

    public String toString() {
        return this.getId();
    }

}
