package de.hegmanns.ejb.session;

import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface AsynchronService {
    Future<Long> add(long summand1, long summand2, long zeitverzoegerung);

    void doLog(String text, long zeitverzoegerung);
}
