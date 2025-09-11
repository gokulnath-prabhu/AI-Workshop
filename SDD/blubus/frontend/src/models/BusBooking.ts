export interface BusBooking {
  id: string;
  operator: string;
  departure: string; // datetime or location
  arrival: string; // datetime or location
  status: 'booked' | 'cancelled';
}
