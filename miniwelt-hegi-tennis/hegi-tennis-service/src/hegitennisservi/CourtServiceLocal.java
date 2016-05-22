package hegitennisservi;

import java.util.Collection;

import javax.ejb.Local;

@Local
public interface CourtServiceLocal {
    CourtBooking bookCourt(String member);

    boolean deleteBooking(String bookingNumber);

    Collection<CourtBooking> getAllBookings(String member);
}
