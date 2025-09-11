# AI Workshop

Prompt Engineering

-   Understanding psychology of AI

-   Transformer models

## How Transformers Work?

-   The words in the prompt are converted to tokens.

-   Generally one word is one token, but might be different in some cases

-   Transformers work on a stochastic or a probabilistic model

-   <https://poloclub.github.io/transformer-explainer/>

## Psychology of AI

-   Zero shot prompting - Ask AI with no examples, just clear instructions

-   One shot prompting - Give one example in the prompt

-   Few shot prompting - Provide a few examples to help AI learn the pattern and tone before prompting

-   Chain-of-thought prompting - Ask AI to think step-by-step to improve logic and reasoning in its answers

-   Prompt Library - GIGO: Garbage In Garbage Out

-   PRD -> User stories -> Acceptance criteria -> Prompts -> Code / Plan

## GitHub repo for the session

-   <https://github.com/gokulnath-prabhu/AI-Workshop>

## Frameworks

-   User stories: INVEST

-   Independent, Negotiable, Valuable, Estimate, Small, Testable

-   Acceptance Criteria: GHERKIN

-   Given, When and Then

-   Given a logged-in user with a successful order in the past 90 days\
    When the user opens the home screen\
    Then the button is visible

-   Prompting: COSTAR

-   Context, Objective, Style, Tone, Audience, Response

## Debugging with Copilot

-   Be very clear with the error received. Instead of putting in just the error or exception, give more context on what exactly is the requirement. Don't just go with one example which went wrong. This can lead to assumptions.

## Error Fixing

-   RIP Method

-   Reproduce, Isolate and Patch

-   Ask the agent to "Write the test case for which this code is failing

## System Changes

-   UIA Method

-   Understand, Impact Analysis, Act

## Spec Driven Development

-   Spec Kit: <https://github.com/gokulnath-prabhu/AI-Workshop>

-   Install UV package: brew install uv

-   Init UV project: uvx --from git+<https://github.com/github/spec-kit.git> specify init <projectName>

-   Creating a new feature:

-   /specify Build an application that can help me organize bus bookings in separate trip groups. Trips are grouped by travel date and can be re-organized by dragging and dropping on the main page. Trips are never inside other nested trips. Within each trip, booked buses are previewed in a tile-like interface.

-   This would create a spec.md file which will contain the entire description of the feature to be implemented, including the user story, acceptance criteria, edge cases and so on.

-   /plan will create a plan for the implementation. We just have to tell which tech stack to be used and other specifications.

-   This will create plan.md, data-model.md, quickstart.md and research.md

-   /tasks Break down plan into tasks

-   This will create [tasks.md](http://tasks.md)

-   For any new features or iterations, do: specify -> plan -> tasks

## Ethical Practices

-   Make sure code is not getting pasted outside the company, like chatgpt

-   Avoid PII - Personal Identification Information. Do not expose API keys

-   Understand tool's data policy

## Best Practices

-   GIGO - Garbage In Garbage Out

-   You are still the pilot. Verify all the changes always
