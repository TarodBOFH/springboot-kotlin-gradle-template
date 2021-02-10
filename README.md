# gradle-template
Gradle project template using:
- `buildSrc` common scripts
- `docs` folder with
  - `adr` for project decisions
  - `todo.yaml` for task management 
- `kotlin` language
  - `kotlin-test` common libraries (including `junit-jupiter`)
  - `spotless` and `ktlint` to manage code conventions
- `springboot` a minimal setup (with exclusions):
  - `web`, `context` and `beans`
  - `jetty`
  - `actuator` production ready endpoints
  - `sleuth` tracing
  - `zalando-logbook` request tracing
  - `httpclient`
  - default configuration and test-configuration

## How is it done?

Convention over Configuration.

The template offers a hook, `versions.gradle.kts`, sitting on `buildSrc` (that includes the default versions).
It also loads `versions.gradle.kts` sitting on root project to override the versions in `buildSrc`. The whole idea is to 
allow a company package `buildSrc` in either a git subtree, or a custom gradle distribution 
(see https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:custom_gradle_distribution)
to  embed a custom `buildSrc` for the company builds.

If multi module setup is used, modules can override default versions either by adding a `buildscript` with a 
`apply(from = "<local.versions.file>")` closure, by adding custom`extra` properties to `buildscript` closure, or by 
adding a default `versions.gradle.kts` on the root of the module.

## Docker

There is a Dockerfile to build the project with docker but there's a more advanced version on `docker/app/Dockerfile`
that uses layered jars to and optimizes build times by reusing layers.

The latter also creates an app image and can also be run with `run.sh` or `run.bat` scripts.

Please check your host configuration for ports and so before running any docker command.
