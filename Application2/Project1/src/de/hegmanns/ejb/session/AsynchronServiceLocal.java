package de.hegmanns.ejb.session;

import java.util.concurrent.Future;

import javax.ejb.Local;

@Local
public interface AsynchronServiceLocal {
    Future<Long> add(long summand1, long summand2, long zeitverzoegerung);

    void doLog(String text, long zeitverzoegerung);
}
