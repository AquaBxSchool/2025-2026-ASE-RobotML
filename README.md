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

### Compiler 

We choosed to make the compiler version, so we can compile our .robot to .ino (Arduino). 

### Typechecker

We implemented a typecheker integrated with the vscode extension and the compiler to give early error/warning/hint. 

### Coverage & Testing

We did a coverage test using mutation testing on:
- [robot-ml-typecheck.ts](./RobotMLangium/packages/language/src/robot-ml-typecheck.ts)
- [robot-ml-generator.ts](./RobotMLangium/packages/language/src/robot-ml-generator.ts)
- [SymbolTable.ts](./RobotMLangium/packages/language/src/SymbolTable.ts)

### Function Renaming & Multi Pass Visitor

We implemented a multi pass visitor to compute a function declaration table to rename functions before the compilation to avoid conflict with reserved function name in arduino (`main`, `setup`, `loop`). 

## Language Model with EMF

![RobotML EMF Diagrame](./robotML.png)

## Language Functionality

### Arduino Interaction

We can get the state of the robot :

```
GetSpeed(millimeter/second)
GetTimeStamp(second)
GetDistance(millimeter)
```

And we can also interact with the robot :

```
Movement(Forward 3 centimenter)
Rotate(3 degrees)
```

### Units

Reserved functions can take multiple units. This is conveniant as the library is using several units, so here they are converted automagically.

```
SetSpeed(30 millimeter/second)

let i = 0

if (GetDistance(centimeter) > 10) {
    Move(Forward 10 centimeter)
}
else {
    Rotate(90 degrees)
}
```

### Control Flow

We provide if/else statement as well as while loop:

```
let i : integer = 2
if ( i < 3 ) {
    //
}
else {
    //
}

while (i < 3){
    i = i + 1
}
```

### Function definition 

A function is defined as : `type` `name` (`name` : `type`,`...`) { `...` }

Exemple : 

```
integer double(val: integer) {
    return val * 2
}
```


# How to run the langium project

You will need [bun](https://bun.com/) and [yarn](https://yarnpkg.com/) to be able to build to project.

Yarn is used to manage the multi-package architecture. It is way easier to interact between packages with it. The dependency version management is easier too.

Bun is used for file system communication and CLI compilation. It is way faster, offers a binary executable for the CLI, and the API is easier.

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
