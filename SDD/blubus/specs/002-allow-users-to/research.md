# Research: Allow users to add source and destination location names when creating a trip group, and improve UI spacing

## Material Design Spacing in React/CSS Modules
- Decision: Use Material Design 8px grid for spacing, padding, and shapes.
- Rationale: Ensures visual consistency and accessibility; widely adopted standard.
- Alternatives: Custom spacing (rejected for lack of consistency).

## Truncating Text and Tooltips in React
- Decision: Truncate location names beyond 30 characters with ellipsis; show full value in a tooltip on hover/focus.
- Rationale: Prevents UI overflow, maintains accessibility.
- Alternatives: Wrapping text (rejected for cluttered UI).

## Validation Patterns for Allowed Characters
- Decision: Allow letters, numbers, spaces, and common place name characters ("-", ",", "."). Use regex validation in form.
- Rationale: Covers most real-world place names, prevents invalid input.
- Alternatives: Allow all characters (rejected for risk of user error).

## State Management
- Decision: Use React Context for trip groups, no DB.
- Rationale: Simpler for demo, no persistence needed.
- Alternatives: LocalStorage, backend API (not required for this phase).
