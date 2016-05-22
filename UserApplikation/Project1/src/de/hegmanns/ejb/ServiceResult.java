package de.hegmanns.ejb;

import java.io.Serializable;

public class ServiceResult implements Serializable {
    private String code;
    public ServiceResult(String code) {
        this.code = code;
        
    }
    
    public static final ServiceResult OK = new ServiceResult("OK");
    public static final ServiceResult NOK = new ServiceResult("NOK");
}
