# Blubus React Web Application Constitution
<!-- Constitution for the Blubus React-based web application -->


## Core Principles

### I. Component-First Architecture
All UI and logic must be implemented as reusable, self-contained React components. Components must be independently testable and documented. No business logic outside components or hooks.

### II. State Management Discipline
Application state must be managed using a predictable, testable approach (e.g., React Context, Redux, Zustand). Global state changes must be explicit and traceable.

### III. Test-First (NON-NEGOTIABLE)
TDD is mandatory: Write tests before implementation. All components, hooks, and utilities must have unit and integration tests. Red-Green-Refactor cycle is strictly enforced.

### IV. Accessibility & UX
All UI must meet WCAG AA accessibility standards. Keyboard navigation, screen reader support, and responsive design are required for all features.

### V. Observability & Error Handling
All errors must be surfaced to users in a clear, actionable way. Use structured logging for client-side errors and user actions. No silent failures.

### VI. Versioning & Simplicity
Follow semantic versioning for releases. Favor simple, declarative solutions. Avoid premature optimization and unnecessary abstractions.


## Additional Constraints & Standards

- **Technology Stack**: Must use React (latest LTS), TypeScript, and a modern CSS-in-JS or CSS Modules approach. No jQuery or legacy frameworks.
- **Security**: All user input must be validated and sanitized. Follow OWASP best practices for web security.
- **Performance**: All pages must load in under 2 seconds on a standard broadband connection. Use code splitting and lazy loading for large bundles.
- **Deployment**: CI/CD pipelines must run all tests and lint checks before deploy. Production builds must be optimized and source maps excluded.


## Development Workflow & Quality Gates

- All work must begin from a feature branch created via the SDD workflow.
- Every PR must include: updated tests, documentation, and a link to the relevant spec.
- Code reviews are mandatory. At least one approval from a senior developer is required.
- All code must pass automated tests, linting, and accessibility checks before merge.
- No direct commits to main or production branches.


## Governance
This constitution supersedes all other development practices for the Blubus React web application. Amendments require documentation, team approval, and a migration plan. All PRs and reviews must verify compliance with this constitution. Any complexity must be justified in the PR description. Refer to the latest guidance file for runtime and development best practices.

**Version**: 1.0.0 | **Ratified**: 2025-09-11 | **Last Amended**: 2025-09-11
<!-- Version: 1.0.0 | Ratified: 2025-09-11 | Last Amended: 2025-09-11 -->