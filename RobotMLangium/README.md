# RobotML - a language for a Robot

Ce dépot à été crée par Tom Chauvel et Titouan Le Dilavrec pour le projet de ASE dirigé par Stéphanie Chalita et Chiara Relevat.

# Project structure

- `packages/language` : This package contains the language definition and the visitors.
- `packages/cli` : The command-line to compile the code.
- `packages/extension` : Contains the VSCode extension with the LSP configured.

## Project Functionality

- Ast Printer
- Compiler
- Typechecker
- Mutability Test
- Coverage
- Multiple Visitor Pass
- Function renaming

## How to run the project

- `yarn build` : build all the npm packages
- `yarn test` : test the language definition and the visitors
- `yarn mutation` : run the mutation testing

# How to run the compiler

- [package.json](./package.json) - The manifest file the main workspace package
- [tsconfig.json](./tsconfig.json) - The base TypeScript compiler configuration
- [tsconfig.build.json](./package.json) - Configuration used to build the complete source code.
- [.gitignore](.gitignore) - Files ignored by git

yarn run cli generate ./test/exemple.robot out 
yarn run cli upload /dev/cu.usbserial-A907TJI5 out
