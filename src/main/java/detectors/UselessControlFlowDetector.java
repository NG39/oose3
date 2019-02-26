package detectors;
import java.util.ArrayList;

import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class UselessControlFlowDetector extends VoidVisitorAdapter <ArrayList<Breakpoints>> {
	public  String getMethodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	@Override
	public void visit( IfStmt IfStmt, ArrayList<Breakpoints> collector) {
		super.visit(IfStmt, collector);
		
		Statement thenStmt = IfStmt.getThenStmt();
		if (thenStmt.equals(null)) {
			String className = this.getClass().getName();
			System.out.println(className);
			String methodName = this.getMethodName();
			int start = IfStmt.getRange().get().begin.line;
			int end = IfStmt.getRange().get().end.line;
			System.out.println(start);
		
			collector.add(new Breakpoints(className, methodName, start, end));
		}
		
	}

}
