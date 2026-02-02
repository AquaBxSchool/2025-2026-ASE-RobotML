import chalk from "chalk";
import { Command } from "commander";
import { NodeFileSystem } from "langium/node";
import { createRobotMlServices } from "robot-ml-language";
import { RobotMlLanguageMetaData } from "robot-ml-language/generated";
import type { RobotML } from "robot-ml-language/semantics";
import { extractAstNode, generateOutput } from "./util.js";
import { $ } from "bun";
import { dirname, join } from "path";

export const generateAction = async (
	source: string,
	destination: string,
): Promise<void> => {
	const services = createRobotMlServices(NodeFileSystem).RobotMl;
	const model = await extractAstNode<RobotML>(source, services);
	model.accept(services.visitors.RobotMLAstPrinterVisitor);

	let code = model.accept(services.visitors.RobotMLGeneratorVisitor);

	const generatedFilePath = generateOutput(destination, code);
	console.log(chalk.green(`Code generated succesfully: ${generatedFilePath}`));
};

export const astAction = async (source: string, _destination: string): Promise<void> => {
	const services = createRobotMlServices(NodeFileSystem).RobotMl;
	const model = await extractAstNode<RobotML>(source, services);
	model.accept(services.visitors.RobotMLAstPrinterVisitor);
};

export const compileAction = async (dir: string): Promise<void> => {
	const exeDir = dirname(process.execPath);
	const libPath = join(exeDir, "lib");
	try {
		const result =
			await $`arduino-cli compile -b arduino:avr:uno ${dir} --libraries ${libPath} --output-dir ${dir}/build`.quiet();
		console.log(result.stdout.toString());
	} catch (err: any) {
		// This will now show you the specific C++ compiler errors in your console
		console.error("Compilation Failed:");
		console.error(err.stderr?.toString() || err.message);
		process.exit(1);
	}
};

export default function main(): void {
	const program = new Command();

	// TODO: use Program API to declare the CLI
	const fileExtensions = RobotMlLanguageMetaData.fileExtensions.join(", ");
	program.command("generate")
		.argument(
			"<file>",
			`source file (possible file extensions: ${fileExtensions})`,
		)
		.argument("<destination>", "destination file")
		.description("Generates code for a provided source file.")
		.action(generateAction);
	program.command("ast")
		.argument(
			"<file>",
			`source file (possible file extensions: ${fileExtensions})`,
		)
		.description("Print AST")
		.action(astAction);
	program.command("compile")
		.argument("<dir>", `arduino project folder previously generated`)
		.description("Compile into binary")
		.action(compileAction);

	program.parse(process.argv);
}

main();
