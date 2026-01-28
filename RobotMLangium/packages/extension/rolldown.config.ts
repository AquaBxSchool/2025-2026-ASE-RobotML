import { defineConfig, RolldownOptions } from "rolldown";

const minify = process.argv.includes("--minify");

const createConfig = (
	input: string,
	dir: string,
	file: string,
): RolldownOptions => ({
	input,
	platform: "node",
	external: ["vscode"],
	output: {
		file,
		dir,
		format: "cjs",
		sourcemap: !minify,
		minify: minify,
		inlineDynamicImports: true,
	},
});

export default defineConfig([
	createConfig("./src/extension.ts", "out", "extension.cjs"),
	createConfig("./src/language.ts", "out", "language.cjs"),
]);
