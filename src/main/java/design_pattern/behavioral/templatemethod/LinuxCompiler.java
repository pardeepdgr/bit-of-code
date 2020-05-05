package design_pattern.behavioral.templatemethod;

public class LinuxCompiler extends CrossCompilerTemplate {

	@Override
	public void readSourceCode() {
		System.out.println("Code has been read from Linux platform.");
	}

	@Override
	public void compile() {
		System.out.println("Code has been compiled in Linux platform.");
	}
}
