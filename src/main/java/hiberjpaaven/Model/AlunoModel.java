package hiberjpaaven.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")

public class AlunoModel extends PessoaModel implements Serializable
{
    private int ra;

    public int getRa() 
    {
        return ra;
    }

    public void setRa(int ra)
    {
        this.ra = ra;
    }       
}
