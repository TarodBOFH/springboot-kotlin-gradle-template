# Use TODO File to track pending tasks and issues

## Context and Problem Statement

We want to keep a track of pending task and issues in this project.
Tasks can be grouped and we might want keep a record of completed stuff.
Which format and structure should these task and issues follow?

## Considered Options

* Jira
* Github Issues
* Plaintext files
* yaml file
* Nothing

## Decision Outcome

Chosen option: "yaml file", because

* Can be consulted offline
* It is next to the code
* Updates on the code can update the file on the same commit keeping issues and tasks synchronized with the code
* The format is lean and fits our development style.
* The structure is comprehensible and facilitates usage & maintenance.
* Allow hierarchies 
* Integrates with our IDE perfectly with folding and todo highlighting
