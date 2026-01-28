import { defineConfig } from 'rolldown';

export default defineConfig(
  [{
    input: './src/index.ts',
    output: { dir: 'dist', format: 'esm', minify: true },
  },
  {
    input: './src/semantics.ts',
    output: { dir: 'dist', format: 'esm', minify: true },
  },
  {
    input: './src/generated.ts',
    output: { dir: 'dist', format: 'esm', minify: true },
  }]
);