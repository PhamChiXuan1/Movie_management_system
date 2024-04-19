package sv.iuh.fit.movie.enums;

import java.io.Serializable;

public enum MovieType implements Serializable {
    PHIM_LE(1),
    PHIM_BO(2),
    PHIM_MOI_CHIEU_RAP(3);
    private final int value;

    MovieType(int value) {
        this.value = value;
    }

}
