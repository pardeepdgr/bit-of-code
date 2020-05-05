package design_pattern.behavioral.templatemethod;

public class ClientIDE {

	public static void main(String[] args) {
		CrossCompilerTemplate compiler = new WindowsCompiler();
		compiler.crossCompile();

		CrossCompilerTemplate compiler2 = new LinuxCompiler();
		compiler2.crossCompile();
	}
}
