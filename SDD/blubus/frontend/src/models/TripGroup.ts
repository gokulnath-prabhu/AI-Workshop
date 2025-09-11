import { BusBooking } from './BusBooking';

export interface TripGroup {
  source: string; // required, 1–30+ chars, allowed: letters, numbers, spaces, '-', ',', '.'
  destination: string; // required, 1–30+ chars, allowed: letters, numbers, spaces, '-', ',', '.'
  travelDate: string; // ISO date, required
  buses: BusBooking[];
  order: number; // for sorting
}
