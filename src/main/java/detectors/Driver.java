package detectors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

public class Driver {
	private static final String FILE_PATH = "C:\\Users\\User\\Desktop\\calculator.java";

	
	public static void main(String [] args) {
		try {
			CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));
			VoidVisitor<ArrayList<Breakpoints>>methodVisitor = new UselessControlFlowDetector();
			ArrayList<Breakpoints> collector = new ArrayList<Breakpoints>();
			
			methodVisitor.visit(cu, collector);
			collector.forEach(m->{
				System.out.println(m.toString());
			});
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
			
		}
	

}

}