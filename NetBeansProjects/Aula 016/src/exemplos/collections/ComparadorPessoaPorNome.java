package exemplos.collections;

import java.util.Comparator;

/**
 *
 * @author 78522
 */
public class ComparadorPessoaPorNome implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        if (o1 != null) {
            if (o1.getNome() != null) {
                if (o2 != null) {
                    if (o2.getNome() != null) {
                        return o1.getNome().compareTo(o2.getNome());
                    }
                }
                return -1;
            }
        }
        return 1;
    }

}
