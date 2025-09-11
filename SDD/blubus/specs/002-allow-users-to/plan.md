# Implementation Plan: Allow users to add source and destination location names when creating a trip group, and improve UI spacing

**Branch**: `002-allow-users-to` | **Date**: 2025-09-11 | **Spec**: specs/002-allow-users-to/spec.md
**Input**: Feature specification from `/specs/002-allow-users-to/spec.md`

## Execution Flow (/plan command scope)
```
1. Load feature spec from Input path
2. Fill Technical Context (scan for NEEDS CLARIFICATION)
3. Evaluate Constitution Check section below
4. Execute Phase 0 → research.md
5. Execute Phase 1 → contracts, data-model.md, quickstart.md, agent-specific template file
6. Re-evaluate Constitution Check section
7. Plan Phase 2 → Describe task generation approach (DO NOT create tasks.md)
8. STOP - Ready for /tasks command
```

## Summary
This feature will allow users to specify both source and destination location names (required, validated, and with allowed characters) along with the travel date when creating a new trip group. The UI will display these details, truncate long names, and prevent duplicate trips. All UI padding, spacing, and shapes will follow Material Design guidelines. No database is required for this phase; state will be managed in React context or component state.

## Technical Context
**Language/Version**: TypeScript, React 19 (Next.js)
**Primary Dependencies**: React, Next.js, React Context, CSS Modules, Material Design guidelines
**Storage**: N/A (in-memory state only)
**Testing**: Jest, React Testing Library
**Target Platform**: Web (modern browsers)
**Project Type**: Web (frontend only for this feature)
**Performance Goals**: UI updates in <100ms, page load <2s
**Constraints**: No DB, must follow accessibility and Material Design
**Scale/Scope**: Single-user, demo-scale (no persistence)

## Constitution Check
**Simplicity**:
- Projects: 1 (frontend only)
- Using framework directly: Yes (React, Next.js)
- Single data model: Yes (TripGroup)
- Avoiding patterns: Yes (no unnecessary abstractions)

**Architecture**:
- EVERY feature as library: N/A (Next.js app structure)
- Libraries listed: React (UI), Next.js (framework), CSS Modules (styling)
- CLI per library: N/A
- Library docs: N/A

**Testing (NON-NEGOTIABLE)**:
- RED-GREEN-Refactor cycle enforced: Yes
- Git commits show tests before implementation: To be enforced
- Order: Contract→Integration→E2E→Unit strictly followed: Yes
- Real dependencies used: Yes (no DB, in-memory only)
- Integration tests for: UI flows, validation, duplicate prevention
- FORBIDDEN: Implementation before test, skipping RED phase

**Observability**:
- Structured logging included: N/A (frontend only, errors surfaced to user)
- Frontend logs → backend: N/A
- Error context sufficient: Yes (user-friendly error messages)

**Versioning**:
- Version number assigned: N/A (feature branch)
- BUILD increments on every change: N/A
- Breaking changes handled: N/A

## Project Structure

### Documentation (this feature)
specs/002-allow-users-to/
├── plan.md              # This file (/plan command output)
├── research.md          # Phase 0 output (/plan command)
├── data-model.md        # Phase 1 output (/plan command)
├── quickstart.md        # Phase 1 output (/plan command)
├── contracts/           # Phase 1 output (/plan command)
└── tasks.md             # Phase 2 output (/tasks command - NOT created by /plan)

### Source Code (repository root)
frontend/
├── src/
│   ├── components/
│   ├── models/
│   ├── context/
│   └── app/
└── tests/

**Structure Decision**: Web application (frontend only)

## Phase 0: Outline & Research
- No open NEEDS CLARIFICATION. All requirements are clear from the spec and user clarifications.
- Research best practices for Material Design spacing in React/CSS Modules.
- Research best practices for truncating text and tooltips in React.
- Research validation patterns for allowed characters in input fields (letters, numbers, '-', ',', '.')

**Output**: research.md with findings and decisions

## Phase 1: Design & Contracts
- Extract TripGroup entity: source (string, required, 1–30+ chars, allowed chars), destination (string, required, 1–30+ chars, allowed chars), date (date), bookings (list)
- UI contract: Form for trip group creation with validation, error messages, and Material Design spacing
- UI contract: Display trip groups with truncated names and tooltips
- UI contract: Prevent duplicate trip groups and show friendly message
- Test scenarios: All user stories and edge cases from the spec

**Output**: data-model.md, /contracts/*, failing tests, quickstart.md, agent-specific file

## Phase 2: Task Planning Approach
- Tasks will be generated from contracts, data model, and quickstart in the next phase
- TDD order: Tests before implementation
- Dependency order: Models/context before UI
- Mark [P] for parallel execution where possible

**Estimated Output**: 25-30 numbered, ordered tasks in tasks.md

## Complexity Tracking
None. No constitution violations.

## Progress Tracking
**Phase Status**:
- [x] Phase 0: Research complete (/plan command)
- [x] Phase 1: Design complete (/plan command)
- [ ] Phase 2: Task planning complete (/plan command - describe approach only)
- [ ] Phase 3: Tasks generated (/tasks command)
- [ ] Phase 4: Implementation complete
- [ ] Phase 5: Validation passed

**Gate Status**:
- [x] Initial Constitution Check: PASS
- [x] Post-Design Constitution Check: PASS
- [x] All NEEDS CLARIFICATION resolved
- [ ] Complexity deviations documented

---
*Based on Constitution v2.1.1 - See `/memory/constitution.md`*
