package bg.keit.api.perforations.service;

import bg.keit.api.perforations.domain.Perforations;

public interface PerforationSevice {
    Perforations findByJobID(int i);

    Perforations findBySerNumberAndEncCode(java.lang.Integer integer, java.lang.String s);

    Perforations findByEncCode(java.lang.String s);
}
