package com.omarehab.appointment_booking.web;

import com.omarehab.appointment_booking.domain.Appointment;
import com.omarehab.appointment_booking.dto.AppointmentDto;
import com.omarehab.appointment_booking.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")  // allow Angular dev
public class AppointmentRestController {

    private final AppointmentService svc;

    public AppointmentRestController(AppointmentService svc) {
        this.svc = svc;
    }

    private AppointmentDto toDto(Appointment a) {
        return new AppointmentDto(
            a.getId(),
            a.getClientName(),
            a.getStartTime(),
            a.getEndTime(),
            a.getNotes(),
            a.isConfirmed()
        );
    }

    private Appointment fromDto(AppointmentDto d) {
        Appointment a = new Appointment();
        // id will be null for create
        a.setId(d.id());
        a.setClientName(d.clientName());
        a.setStartTime(d.startTime());
        a.setEndTime(d.endTime());
        a.setNotes(d.notes());
        a.setConfirmed(d.confirmed());
        return a;
    }

    @GetMapping
    public List<AppointmentDto> listAll() {
        return svc.findAll().stream()
                  .map(this::toDto)
                  .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AppointmentDto getOne(@PathVariable Long id) {
        return toDto(svc.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentDto create(@RequestBody AppointmentDto dto) {
        Appointment saved = svc.save(fromDto(dto));
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public AppointmentDto update(
        @PathVariable Long id,
        @RequestBody AppointmentDto dto
    ) {
        Appointment toUpdate = fromDto(dto);
        toUpdate.setId(id);
        return toDto(svc.save(toUpdate));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        svc.deleteById(id);
    }
}
