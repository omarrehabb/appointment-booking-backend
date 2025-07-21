package com.omarehab.appointment_booking.controller;

import com.omarehab.appointment_booking.domain.Appointment;
import com.omarehab.appointment_booking.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentViewController {

    private final AppointmentService appointmentService;

    public AppointmentViewController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointmentForm";      // renders /WEB-INF/jsp/appointmentForm.jsp
    }

    @PostMapping
    public String submitForm(@ModelAttribute Appointment appointment) {
        appointmentService.save(appointment);
        return "redirect:/appointments";  // issues 302 → /appointments
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("appointments", appointmentService.findAll());
        return "appointmentList";      // renders /WEB-INF/jsp/appointmentList.jsp
    }
}
