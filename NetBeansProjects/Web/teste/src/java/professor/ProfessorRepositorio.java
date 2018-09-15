package professor;

import certificacoes.Certificacao;
import comuns.Endereco;
import comuns.Escolaridade;
import comuns.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class ProfessorRepositorio {
    
    private static List<Professor> professores = new ArrayList<>();
    
    static {
        List<Certificacao> certificacoes = new ArrayList<>();
        certificacoes.add(new Certificacao(1l,"Java", "Oracle"));
        certificacoes.add(new Certificacao(2l,"Oracle", "Oracle"));
        professores.add(new Professor(1L, "Professor1", "Sobrenome1", "professor1@teste",Escolaridade.superiorCompleto, "123456", "12345678912",
                 new Endereco( 123, "teste", "complemento", "bairro testado", "cidade teste", 89130000, Estado.tocantins),certificacoes ));
        professores.add(new Professor(1L, "Professor2", "Sobrenome1", "professor1@teste",Escolaridade.superiorCompleto, "123456", "12345678912",
                 new Endereco( 123, "teste", "complemento", "bairro testado", "cidade teste", 89130000, Estado.tocantins),certificacoes ));
    }
    
    public List<Professor> buscarTodos() {
        return professores;
    }

    public Professor salvar(Professor professor) {
        if (professor.getId() == null) {
            professor.setId(System.currentTimeMillis());
        }
        int indexOf = professores.indexOf(professor);
        if (indexOf > -1) {
            professores.set(indexOf, professor);
        } else {
            professores.add(professor);
        }
        return professor;
    }
    
    public boolean remover(Professor professor){
        return professores.remove(professor);
    }
    
    public Professor buscarPorId(Long id){
        for (Professor professor : professores) {
            if(id.equals(professor.getId())){
                return professor;
            }
        }
        return null;
    }

    public Professor buscarPorEmail(String email){
        for (Professor professor : professores) {
            if(email.equals(professor.getEmail())){
                return professor;
            }
        }
        return null;
    }
    
}
