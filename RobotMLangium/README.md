# Workspace overview

- `packages/language` : This package contains the language definition and the visitors.
- `packages/cli` : The command-line to compile the code.
- `packages/extension` : Contains the VSCode extension with the LSP configured.

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

# RobotML - a language for a Robot

Ce dépot à été crée par Tom Chauvel et Titouan Le Dilavrec pour le projet de ASE dirigé par Stéphanie Chalita et Chiara Relevat.

## Project Structure

- [packages/language](./packages/language/README.md) This package is always available and contains the language definition.
- [packages/cli](./packages/cli) A package to execute command.
  -  
- [packages/extension](./packages/extension/langium-quickstart.md) *Optional* Contains the VSCode extension if you chose to create it.

## Project Functionality

- Ast Printer
- Compiler
- Typechecker
- Mutability Test
- Coverage
- Multiple Visitor Pass
- Function renaming
./packages/cli/dist/cli generate ./test/exemple.robot out 
./packages/cli/dist/cli yarn run cli upload /dev/cu.usbserial-A907TJI5 out
