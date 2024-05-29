package com.emrah.emrah.service;

import com.emrah.emrah.exception.ResourceNotFoundException;
import com.emrah.emrah.model.Reservation;
import com.emrah.emrah.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id " + id));
        reservation.setFirstName(reservationDetails.getFirstName());
        reservation.setLastName(reservationDetails.getLastName());
        reservation.setEmail(reservationDetails.getEmail());
        reservation.setPhoneNumber(reservationDetails.getPhoneNumber());
        reservation.setDate(reservationDetails.getDate());
        reservation.setTime(reservationDetails.getTime());
        reservation.setNumberOfPeople(reservationDetails.getNumberOfPeople());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id " + id));
        reservationRepository.delete(reservation);
    }
}