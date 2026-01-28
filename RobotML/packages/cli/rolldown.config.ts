import { defineConfig } from 'rolldown';

export default defineConfig(
  {
    input: './src/ast.ts',
    output: { dir: 'dist', format: 'esm', minify:true },
  }
);