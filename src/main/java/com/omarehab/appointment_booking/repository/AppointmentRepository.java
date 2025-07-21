package com.omarehab.appointment_booking.repository;

import com.omarehab.appointment_booking.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for Appointment entities.
 * Provides CRUD operations and paging/sorting out of the box.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Example custom query methods to be added as needed:
    // List<Appointment> findByClientName(String clientName);
    // List<Appointment> findByStartTimeBetween(LocalDateTime from, LocalDateTime to);
}
