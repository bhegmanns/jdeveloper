package hegitennisservi;

import java.io.Serializable;

import java.time.chrono.AbstractChronology;

import java.util.Optional;

public class CourtBooking implements Serializable {
    Optional<Long> countNumber;
    private String zeitraum;
    public CourtBooking() {
        super();
    }


    

    public void setZeitraum(String zeitraum) {
        this.zeitraum = zeitraum;
    }

    public String getZeitraum() {
        return zeitraum;
    }
}
