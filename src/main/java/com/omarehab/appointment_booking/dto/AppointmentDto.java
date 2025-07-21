package com.omarehab.appointment_booking.dto;

import java.time.LocalDateTime;

public record AppointmentDto(
    Long id,
    String clientName,
    LocalDateTime startTime,
    LocalDateTime endTime,
    String notes,
    boolean confirmed
) {}
