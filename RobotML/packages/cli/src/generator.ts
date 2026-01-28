import { expandToNode, joinToNode, toString } from "langium/generate";
import * as fs from "node:fs";
import { extractDestinationAndName } from "./util.js";
import { RobotML } from "robot-ml-language/semantics";

export function generateOutput(
	model: RobotML,
	source: string,
	destination: string,
): string {
	const data = extractDestinationAndName(destination);

	const fileNode = expandToNode`
        // TODO : place here generated code
		// ${joinToNode(model.functions)}
		`.appendNewLineIfNotEmpty();
		
		// ${model.accept(services.visitors.HelloWorldInterpreter)}
	if (!fs.existsSync(data.destination)) {
		fs.mkdirSync(data.destination, { recursive: true });
	}
	fs.writeFileSync(destination, toString(fileNode));
	return destination;
}
