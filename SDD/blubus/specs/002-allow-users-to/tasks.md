# Tasks: Allow users to add source and destination location names when creating a trip group, and improve UI spacing

**Input**: Design documents from `/specs/002-allow-users-to/`
**Prerequisites**: plan.md (required), research.md, data-model.md, contracts/

## Execution Flow (main)
```
1. Load plan.md from feature directory
2. Load optional design documents: data-model.md, contracts/, research.md
3. Generate tasks by category: Setup, Tests, Core, Integration, Polish
4. Apply task rules: [P] for parallel, sequential for same file, TDD order
5. Number tasks sequentially (T001, T002...)
6. Generate dependency graph
7. Create parallel execution examples
8. Validate task completeness
9. Return: SUCCESS (tasks ready for execution)
```

## Format: `[ID] [P?] Description`
- **[P]**: Can run in parallel (different files, no dependencies)
- Include exact file paths in descriptions

## Phase 3.1: Setup
- [ ] T001 Ensure project structure matches plan (frontend/src/components, models, context, app, tests)
- [ ] T002 [P] Confirm Material Design guidelines are available for reference

## Phase 3.2: Tests First (TDD)
- [ ] T003 [P] Write contract test for trip group creation form validation (required fields, allowed characters) in frontend/tests/unit/TripGroupForm.test.tsx
- [ ] T004 [P] Write contract test for duplicate trip group prevention in frontend/tests/unit/TripGroupContext.test.ts
- [ ] T005 [P] Write integration test for trip group creation and display (source, destination, date, truncation, tooltip) in frontend/tests/integration/TripGroupFlow.test.tsx
- [ ] T006 [P] Write accessibility test for trip group creation and display in frontend/tests/integration/TripGroupA11y.test.tsx

## Phase 3.3: Core Implementation (ONLY after tests are failing)
- [ ] T007 [P] Update TripGroup model to include source and destination fields in frontend/src/models/TripGroup.ts
- [ ] T008 [P] Update TripGroupsContext to handle new fields, validation, and duplicate prevention in frontend/src/context/TripGroupsContext.tsx
- [ ] T009 [P] Implement trip group creation form with source, destination, date, validation, and Material Design spacing in frontend/src/components/TripGroupForm.tsx
- [ ] T010 [P] Update TripGroupList and BusBookingTile to display new fields, truncate long names, and show tooltips in frontend/src/components/TripGroupList.tsx and BusBookingTile.tsx
- [ ] T011 [P] Refactor CSS Modules for Material Design spacing and shapes in frontend/src/components/*.module.css

## Phase 3.4: Polish & Docs
- [ ] T012 [P] Add user-friendly error messages for validation and duplicate prevention in frontend/src/components/TripGroupForm.tsx
- [ ] T013 [P] Update quickstart.md and documentation in specs/002-allow-users-to/quickstart.md

## Dependency Graph
- T001, T002 → T003, T004, T005, T006 → T007, T008, T009, T010, T011 → T012, T013

## Parallel Execution Examples
- T003–T006 can be written in parallel
- T007–T011 can be implemented in parallel after tests are written
- T012, T013 can be done in parallel after core implementation

---
*Based on SDD workflow and project constitution*
