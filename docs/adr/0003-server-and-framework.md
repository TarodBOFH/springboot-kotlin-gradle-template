# Server and Framework

## Context and Problem Statement

We want to publish the API, and we need a server.
In order to ease server configuration and boilerplate code, we need a framework. 

## Considered Options

- KTor
- Spring
- No Framework (plain JEE)

## Decision Outcome

We will use Spring with Springboot because:
- It is widely known
- There is plenty of documentation and fits our use case
- We have experience with it
- We lack experience with Ktor to use as production-ready solution

We will use Jetty as WebContainer and tune SpringBoot configuration to:
- reduce startup time as well
- reduce the number of dependencies
