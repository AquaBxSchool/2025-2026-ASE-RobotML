# Workspace overview

Depending on the selection during the project generation you will have one or more packages contained in the packages directory.
Please check the specific projects here:

- [packages/language](./packages/language/README.md) This package is always available and contains the language definition.
- [packages/cli](./packages/cli/README.md) *Optional* Is only available if you chose to use the command-line interface.
- [packages/extension](./packages/extension/langium-quickstart.md) *Optional* Contains the VSCode extension if you chose to create it.

## What's in the folder?

Some file are contained in the root directory as well.

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
