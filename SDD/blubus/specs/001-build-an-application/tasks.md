# Tasks: Organize Bus Bookings by Trip Groups

**Input**: Design documents from `/specs/001-build-an-application/`
**Prerequisites**: plan.md (required), research.md, data-model.md, contracts/

## Phase 3.1: Setup
- [ ] T001 Create `frontend/` project structure per implementation plan
- [ ] T002 Initialize Next.js project in `frontend/` with TypeScript
- [ ] T003 [P] Configure ESLint, Prettier, and stylelint in `frontend/`

## Phase 3.2: Tests First (TDD)
- [ ] T004 [P] Unit test for TripGroup model in `frontend/tests/unit/tripGroup.test.ts`
- [ ] T005 [P] Unit test for BusBooking model in `frontend/tests/unit/busBooking.test.ts`
- [ ] T006 [P] Integration test for drag-and-drop reordering in `frontend/tests/integration/dragAndDrop.test.tsx`
- [ ] T007 [P] Integration test for empty state and add trip group in `frontend/tests/integration/emptyState.test.tsx`
- [ ] T008 [P] Integration test for tile preview in `frontend/tests/integration/tilePreview.test.tsx`
- [ ] T009 [P] Accessibility test for trip group and bus booking tiles in `frontend/tests/integration/a11y.test.tsx`

## Phase 3.3: Core Implementation
- [ ] T010 [P] Implement TripGroup model in `frontend/src/models/TripGroup.ts`
- [ ] T011 [P] Implement BusBooking model in `frontend/src/models/BusBooking.ts`
- [ ] T012 [P] Implement TripGroupsContext for state management in `frontend/src/context/TripGroupsContext.tsx`
- [ ] T013 [P] Implement drag-and-drop trip group list in `frontend/src/components/TripGroupList.tsx`
- [ ] T014 [P] Implement tile preview for bus bookings in `frontend/src/components/BusBookingTile.tsx`
- [ ] T015 [P] Implement empty state UI in `frontend/src/components/EmptyState.tsx`
- [ ] T016 [P] Implement accessibility features (ARIA, keyboard navigation) in all components

## Phase 3.4: Polish
- [ ] T017 [P] Add unit tests for context and components in `frontend/tests/unit/`
- [ ] T018 [P] Add E2E tests for drag-and-drop and accessibility in `frontend/tests/e2e/`
- [ ] T019 [P] Update documentation in `frontend/README.md`
- [ ] T020 [P] Manual test using quickstart steps

## Dependencies
- Tests (T004-T009) before implementation (T010-T016)
- Models/context (T010-T012) before components (T013-T016)
- Implementation before polish (T017-T020)

## Parallel Example
```
# Launch T004-T009 together:
Task: "Unit test for TripGroup model in frontend/tests/unit/tripGroup.test.ts"
Task: "Unit test for BusBooking model in frontend/tests/unit/busBooking.test.ts"
Task: "Integration test for drag-and-drop reordering in frontend/tests/integration/dragAndDrop.test.tsx"
Task: "Integration test for empty state and add trip group in frontend/tests/integration/emptyState.test.tsx"
Task: "Integration test for tile preview in frontend/tests/integration/tilePreview.test.tsx"
Task: "Accessibility test for trip group and bus booking tiles in frontend/tests/integration/a11y.test.tsx"
```

## Validation Checklist
- [ ] All entities have model tasks
- [ ] All tests come before implementation
- [ ] Parallel tasks truly independent
- [ ] Each task specifies exact file path
- [ ] No task modifies same file as another [P] task
