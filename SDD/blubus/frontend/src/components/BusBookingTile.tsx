import React from 'react';
import { BusBooking } from '../models/BusBooking';
import styles from './BusBookingTile.module.css';

interface BusBookingTileProps {
  booking: BusBooking;
}

export const BusBookingTile: React.FC<BusBookingTileProps> = ({ booking }) => (
  <div
    role="button"
    tabIndex={0}
    aria-label={`Bus booking: ${booking.operator}, ${booking.departure} to ${booking.arrival}`}
    className={styles.busBookingTile}
    onKeyDown={e => {
      if (e.key === 'Enter' || e.key === ' ') {
        // Placeholder for future click/activate action
        e.preventDefault();
      }
    }}
  >
    <div><strong>Operator:</strong> {booking.operator}</div>
    <div><strong>Departure:</strong> {booking.departure}</div>
    <div><strong>Arrival:</strong> {booking.arrival}</div>
    <div><strong>Status:</strong> {booking.status}</div>
  </div>
);
