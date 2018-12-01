import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

public class TestJavaParser {
	
	@Test
	public void testChoke() throws FileNotFoundException {
		TypeSolver typeSolver = new ReflectionTypeSolver(false);
		JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
		JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);
		
		
		CompilationUnit source = JavaParser.parse(new File("src/main/java/main/MainClass.java"));
		boolean failed = false;
		
		for (MethodCallExpr mce : source.findAll(MethodCallExpr.class)) {
			System.out.println("Solving at " + source.getType(0).getNameAsString() + " " + mce.getBegin().get() + ": " + mce.getNameAsString());
			
			try {
				mce.resolve();
				System.out.println("Success!");
			} catch (Exception e) {
				System.err.println("Error :(");
				e.printStackTrace();
				failed = true;
			}
			
			System.out.println();
		}
		
		assertFalse(failed);
	}
	
}
