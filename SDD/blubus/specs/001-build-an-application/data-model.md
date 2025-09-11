# Data Model: Organize Bus Bookings by Trip Groups

## Entities

### TripGroup
- **travelDate**: string (ISO date)
- **buses**: BusBooking[]
- **order**: number (for sorting)

### BusBooking
- **id**: string (unique)
- **operator**: string
- **departure**: string (datetime or location)
- **arrival**: string (datetime or location)
- **status**: string (e.g., 'booked', 'cancelled')

## Relationships
- TripGroup has many BusBooking
- BusBooking belongs to one TripGroup

## Validation Rules
- travelDate must be a valid date
- order must be unique among trip groups
- status must be one of allowed values
