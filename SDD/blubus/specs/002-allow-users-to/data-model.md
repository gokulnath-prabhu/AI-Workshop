# Data Model: Allow users to add source and destination location names when creating a trip group, and improve UI spacing

## Entity: TripGroup
- source: string (required, 1–30+ chars, allowed: letters, numbers, spaces, '-', ',', '.')
- destination: string (required, 1–30+ chars, allowed: letters, numbers, spaces, '-', ',', '.')
- date: Date (required)
- bookings: BusBooking[]

## Entity: BusBooking
- (Unchanged from previous model)

## Validation Rules
- Source and destination are required and must match allowed character set.
- No duplicate TripGroup (same source, destination, date).
- Truncate display of source/destination at 30 chars, show tooltip for full value.
