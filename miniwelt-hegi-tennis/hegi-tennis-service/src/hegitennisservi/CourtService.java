package hegitennisservi;

import java.util.Collection;

import javax.ejb.Remote;

@Remote
public interface CourtService {
    CourtBooking bookCourt(String member);

    boolean deleteBooking(String bookingNumber);

    Collection<CourtBooking> getAllBookings(String member);
}
