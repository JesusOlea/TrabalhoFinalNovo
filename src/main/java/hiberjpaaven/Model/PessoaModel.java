package hiberjpaaven.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class PessoaModel implements Serializable 
{	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpessoa;
    private String nome;
    private int idade;
    private long cpf;
    private String sexo;
    
	public long getIdpessoa() 
        {
            return idpessoa;
	}
	public void setIdpessoa(long idpessoa)
        {
            this.idpessoa = idpessoa;
	}
	public String getNome() 
        {
            return nome;
	}
	public void setNome(String nome) 
        {
            this.nome = nome;
	}
	public int getIdade() 
        {
            return idade;
	}
	public void setIdade(int idade) 
        {
            this.idade = idade;
	}
	public long getCpf() 
        {
            return cpf;
	}
	public void setCpf(long cpf) 
        {
            this.cpf = cpf;
	}
	public String getSexo() 
        {
            return sexo;
	}
	public void setSexo(String sexo)
        {
            this.sexo = sexo;
	}
}
