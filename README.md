# RobotML - a language for a Robot

Ce dépot à été crée par Tom Chauvel et Titouan Le Dilavrec pour le projet de ASE dirigé par Stéphanie Chalita et Chiara Relevat.

# Project structure

| Package                            | Description                                                     |
| ---------------------------------- | --------------------------------------------------------------- |
| `RobotMLangium/packages/language`  | This package contains the language definition and the visitors. |
| `RobotMLangium/packages/cli`       | The command-line to compile the code.                           |
| `RobotMLangium/packages/extension` | Contains the VSCode extension with the LSP configured.          |
| `EMF/RobotML/`                     | EMF main project with .ecore & .aird                            |
| `EMF/Xtext/`                       | Xtext projects, not used :(                                     |
| `archived/`                        | Other irrelevant files                                          |

## Project Functionality

- Ast Printer
- Compiler
- Typechecker
- Mutation Testing
- Coverage
- Multiple Visitor Pass
- Function renaming

## Language Model with EMF

![RobotML EMF Diagrame](./robotML.png)

## How to run the langium project

You will need [bun](https://bun.com/) and [yarn](https://yarnpkg.com/) to be able to build to project.

Yarn is used to managed the multi-packages architecture.
Bun for the file system communication and the CLI compilation.

From `./RobotMLangium` run the following commands

| Command         | Description                                      |
| --------------- | ------------------------------------------------ |
| `yarn install`  | install the dependencies                         |
| `yarn build`    | build the entire project and also run the tests. |
| `yarn test`     | test the language definition and the visitors.   |
| `yarn mutation` | run the mutation testing.                        |

# How to use the compiler

From `./RobotMLangium` run the following commands

| Command                                                        | Exemple                                                         | Description |
| -------------------------------------------------------------- | --------------------------------------------------------------- | ----------- |
| `./packages/cli/dist/cli generate {robot_file} {project_name}` | `./packages/cli/dist/cli generate ./test/exemple.robot out`     |             |
| `./packages/cli/dist/cli compile {project_name}`               | `./packages/cli/dist/cli compile out`                           |             |
| `./packages/cli/dist/cli upload {serial_port} {project_name}`  | `./packages/cli/dist/cli upload /dev/cu.usbserial-A907TJI5 out` |             |
