
public class XMLFormulaFormatter implements FormulaFormatter,FormulaVisitor<String> {
	public String format(Formula f){
		return f.accept(this);
	}
	public String visit(Constant constant){
		return "< const >" + constant.asString() +"</ const >";
	}
	public String visit(Sum sum){
		
		}
	
	public String visit(Product product){
		
	}
}
