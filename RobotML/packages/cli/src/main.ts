import {
	createRobotMlServices,
} from "robot-ml-language";
import {
	RobotML
} from "robot-ml-language/semantics";
import {
	RobotMlLanguageMetaData,
} from "robot-ml-language/generated";

import chalk from "chalk";
import { Command } from "commander";
import { extractAstNode } from "./util.js";
import { generateOutput } from "./generator.js";
import { NodeFileSystem } from "langium/node";

export const generateAction = async (
	source: string,
	destination: string,
): Promise<void> => {
	const services = createRobotMlServices(NodeFileSystem).RobotMl;
	const model = await extractAstNode<RobotML>(source, services);
	const generatedFilePath = generateOutput(model, source, destination);
	model.accept(services.visitors.RobotMLAstPrinterVisitor)
	console.log(chalk.green(`Code generated succesfully: ${generatedFilePath}`));
};

export const astAction = async (
	source: string,
	destination: string,
): Promise<void> => {
	const services = createRobotMlServices(NodeFileSystem).RobotMl;
	const model = await extractAstNode<RobotML>(source, services);
	model.accept(services.visitors.RobotMLAstPrinterVisitor)
};

export default function main(): void {
	const program = new Command();

	// TODO: use Program API to declare the CLI
	const fileExtensions = RobotMlLanguageMetaData.fileExtensions.join(", ");
	program
		.command("generate")
		.argument(
			"<file>",
			`source file (possible file extensions: ${fileExtensions})`,
		)
		.argument("<destination>", "destination file")
		.description("Generates code for a provided source file.")
		.action(generateAction);
	program
		.command("ast")
		.argument(
			"<file>",
			`source file (possible file extensions: ${fileExtensions})`,
		)
		.description("Print AST")
		.action(astAction);

	program.parse(process.argv);
}

main()