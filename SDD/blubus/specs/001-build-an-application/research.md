# Phase 0: Research

## Drag-and-Drop in Next.js
- **Decision**: Use React DnD for drag-and-drop functionality.
- **Rationale**: React DnD is widely adopted, well-documented, and integrates smoothly with React/Next.js.
- **Alternatives considered**: react-beautiful-dnd (good for lists, but React DnD is more flexible for custom tile layouts).

## Accessible Tile Interfaces
- **Decision**: Use semantic HTML, ARIA roles, and keyboard navigation for all tiles.
- **Rationale**: Ensures compliance with WCAG AA and good UX for all users.
- **Alternatives considered**: No alternatives; accessibility is non-negotiable.

## In-Memory State Management
- **Decision**: Use React Context for global state (trip groups, bookings).
- **Rationale**: Simple, built-in, and sufficient for demo scale.
- **Alternatives considered**: Redux, Zustand (overkill for this scope).

## Testing
- **Decision**: Use Jest and React Testing Library for unit/integration, Cypress for E2E.
- **Rationale**: Standard for React/Next.js projects.
- **Alternatives considered**: Playwright (Cypress is more common in React ecosystem).
