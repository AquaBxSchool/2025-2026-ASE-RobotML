# RobotML - a language for a Robot

Ce dépot à été crée par Tom Chauvel et Titouan Le Dilavrec pour le projet de ASE dirigé par Stéphanie Chalita et Chiara Relevat.

# Project structure

| Package | Description |
| --- | --- |
| `packages/language` | This package contains the language definition and the visitors. |
| `packages/cli` | The command-line to compile the code. |
| `packages/extension` | Contains the VSCode extension with the LSP configured. |

## Project Functionality

- Ast Printer
- Compiler
- Typechecker
- Mutability Test
- Coverage
- Multiple Visitor Pass
- Function renaming

## How to run the project

| Command | Description |
| --- | --- |
| `yarn build` | build the entire project and also run the tests. |
| `yarn test` | test the language definition and the visitors. |
| `yarn mutation` | run the mutation testing. |

# How to use the compiler

<!-- - [package.json](./package.json) - The manifest file the main workspace package
- [tsconfig.json](./tsconfig.json) - The base TypeScript compiler configuration
- [tsconfig.build.json](./package.json) - Configuration used to build the complete source code.
- [.gitignore](.gitignore) - Files ignored by git -->



| Command | Exemple |Description |
| --- | --- |--- |
| `./packages/cli/dist/cli generate {robot_file} {project_name}` | `./packages/cli/dist/cli generate ./test/exemple.robot out` | 
| `./packages/cli/dist/cli compile {project_name}` | `./packages/cli/dist/cli compile out`  | 
| `./packages/cli/dist/cli upload {serial_port} {project_name}` | `./packages/cli/dist/cli upload /dev/cu.usbserial-A907TJI5 out` |