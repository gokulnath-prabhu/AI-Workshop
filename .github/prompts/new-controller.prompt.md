---
description: Create a new REST controller endpoint in a Spring Boot 17 application using Java records for DTOs
mode: creator
model: Claude Sonnet 3.5
---

Goal:
- Create a RESTful controller <EntityName> in a <Framework>
- Ensure the controller includes standard CRUD operations: Create, Read, Update, Delete
- Include error handling and validations
- Write clear and concise comments for each method
- Generate unit tests for the controller methods

Input Variables:
- EntityName: The name of the entity (e.g., User, Product)
- Framework: The web framework to be used (e.g., Spring Boot, Express.js)

Constraints:
- Use dependency injection where applicable
- Ensure the code is modular and follows best practices
- Follow '.github/copilot-standards.md' for coding standards and practices

Deliverables:
- A complete REST controller code snippet
- 'src/controllers/<EntityName>Controller.java' file path