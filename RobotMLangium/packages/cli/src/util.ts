import * as path from "node:path";
import chalk from "chalk";
import type { AstNode, LangiumCoreServices } from "langium";
import { parseHelper } from "langium/test";
import libc from "./lib.c" with { type: "text" };

export function generateOutput(destination: string, content: string): string {
	const file = Bun.file(`${destination}/${destination}.ino`);

	if (!file.exists()) {
		console.error(chalk.red(`File ${destination} does not exist.`));
		process.exit(1);
	}

	file.write(libc + content);

	return destination;
}

export async function extractAstNode<T extends AstNode>(
	fileName: string,
	services: LangiumCoreServices,
): Promise<T> {
	const extensions = services.LanguageMetaData.fileExtensions;
	if (!extensions.includes(path.extname(fileName))) {
		console.error(
			chalk.yellow(
				`Please choose a file with one of these extensions: ${extensions}.`,
			),
		);
		process.exit(1);
	}

	const parse = parseHelper(services);

	const file = Bun.file(fileName);

	if (!file.exists()) {
		console.error(chalk.red(`File ${fileName} does not exist.`));
		process.exit(1);
	}

	const filetext = await file.text();

	const document = await parse(filetext, { validation: true });

	const validationErrors = (document.diagnostics ?? []).filter(
		(e) => e.severity === 1,
	);
	if (validationErrors.length > 0) {
		console.error(chalk.red("There are validation errors:"));
		for (const validationError of validationErrors) {
			console.error(
				chalk.red(
					`line ${validationError.range.start.line + 1}: ${validationError.message} [${document.textDocument.getText(validationError.range)}]`,
				),
			);
		}
		process.exit(1);
	}

	return document.parseResult?.value as T;
}

interface FilePathData {
	destination: string;
	name: string;
}

export function extractDestinationAndName(destination: string): FilePathData {
	return {
		destination: path.dirname(destination),
		name: path.basename(destination),
	};
}
