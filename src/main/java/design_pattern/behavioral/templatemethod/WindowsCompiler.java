package design_pattern.behavioral.templatemethod;

public class WindowsCompiler extends CrossCompilerTemplate{

	@Override
	public void readSourceCode() {
		System.out.println("Code has been read from Windows platform.");
	}

	@Override
	public void compile() {
		System.out.println("Code has been compiled in Windows platform.");
	}

}
