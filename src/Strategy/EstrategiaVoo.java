package Strategy;

import Impl.Voo;

import java.time.LocalDateTime;
import java.util.Comparator;

public class EstrategiaVoo implements Comparator<Voo> {

    @Override
    public int compare(Voo v1, Voo v2) {
        LocalDateTime d1 = v1.getDataVoo();
        LocalDateTime d2 = v2.getDataVoo();

        return d1.compareTo(d2);

    }
}
