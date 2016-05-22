package de.hegmanns.ejb.session;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateless(name = "AsynchronService", mappedName = "Application2-Project1-AsynchronService")
@Asynchronous
public class AsynchronServiceBean implements AsynchronService, AsynchronServiceLocal {
    @Resource
    SessionContext sessionContext;

    public AsynchronServiceBean() {
    }


    public void doLog(String text, long zeitverzoegerung) {
        try {
            Thread.sleep(zeitverzoegerung * 1000);
        } catch (InterruptedException e) {
        }

        System.out.println("" + text);
    }

    public Future<Long> add(long summand1, long summand2, long zeitverzoegerung) {
        try {
            Thread.sleep(zeitverzoegerung * 1000);
        } catch (InterruptedException e) {
        }
        long summe = summand1 + summand2;
        System.out.println("" + summe);
        return new AsyncResult<Long>(summe);
    }
}
