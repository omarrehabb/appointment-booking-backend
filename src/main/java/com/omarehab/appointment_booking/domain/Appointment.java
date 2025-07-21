package com.omarehab.appointment_booking.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Appointment {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String clientName;

  @NotNull
  private LocalDateTime startTime;

  @NotNull
  private LocalDateTime endTime;

  private String notes;

  private boolean confirmed;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getClientName() {
    return clientName;
  }
  public void setClientName(String clientName) {
    this.clientName = clientName;
  }
  public LocalDateTime getStartTime() {
    return startTime;
  }
  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }
  public LocalDateTime getEndTime() {
    return endTime;
  }
  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
  }
  public boolean isConfirmed() {
    return confirmed;
  }
  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }
  @Override
  public String toString() {  
    return "Appointment{" +
            "id=" + id +
            ", clientName='" + clientName + '\'' +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", notes='" + notes + '\'' +
            ", confirmed=" + confirmed +
            '}';
  }
}
