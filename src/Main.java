
public class Main {
	public static void main ( String [] args ) {
		Variable a= new Variable ("a", 10);
		Variable b= new Variable ("b", 20);
		Constant c= new Constant (30);
		Formula formula = new Product ( new Sum (b ,c), new Sum (a , b ));
		FormulaFormatter latex = new LatexFormulaFormatter ();
		System . out . println ( latex . format ( formula ));


		int indentLevel = 0, indentWidth = 3;
		FormulaFormatter xml= new XMLFormulaFormatter ( indentLevel , indentWidth );
		System .out. println (xml. format ( formula ));
	}
}
