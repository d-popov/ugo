
public class LatexFormulaFormatter implements FormulaFormatter,FormulaVisitor<String>{
	public String format(Formula f){
		return f.accept(this);
	}
	public String visit(Constant constant){
		return constant.asString();
	}
	public String visit(Sum sum){
		return sum.asString();
	}
	public String visit(Product product){
		String multiplication = product.asString();
		for(int i=0;i<multiplication.length();i++) {
			if(multiplication.charAt(i)=='*') {
				break;
			}
			int arret=i;
		}
		StringBuilder resultat = new StringBuilder();
		for(int j=0;j<multiplication.length();j++) {
			if(arret==j) {
				continue;
			}	
			resultat.append(multiplication.charAt(j));
		}
			return resultat.toString();
	}
}

