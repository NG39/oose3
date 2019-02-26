package detectors;

public class Breakpoints {
	private String className;
	private String methodName;
	private int startline;
	private int endline;
	
	public Breakpoints(String className, String methodName, int startline, int endline) {
		this.className = className;
		this.methodName = methodName;
		this.startline= startline;
		this.endline = endline;
	}
	@Override
	public String toString() {
		return "ClassName = " +className + ", MethodName = "+ methodName + ", startline = "+ startline + ", endline = " + endline;
	}

}
