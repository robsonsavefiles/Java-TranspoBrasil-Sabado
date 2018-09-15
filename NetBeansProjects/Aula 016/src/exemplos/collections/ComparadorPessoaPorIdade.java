package exemplos.collections;

import java.util.Comparator;

/**
 *
 * @author 78522
 */
public class ComparadorPessoaPorIdade implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        if (o1 != null) {
            if (o2 != null) {
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
            return -1;
        }
        return 1;
    }

}
