package hegitennisservi;

import java.util.Collection;

import java.util.Collections;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "CourtService", mappedName = "miniwelt-hegi-tennis-hegi-tennis-service-CourtService")
public class CourtServiceBean implements CourtService, CourtServiceLocal {
    @Resource
    SessionContext sessionContext;

    public CourtServiceBean() {
    }

    public CourtBooking bookCourt(String member) {
        return null;
    }

    public Collection<CourtBooking> getAllBookings(String member) {
        return Collections.emptyList();
    }

    public boolean deleteBooking(String bookingNumber) {
        return false;
    }
}
