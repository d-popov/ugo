import com.sun.org.apache.regexp.internal.recompile;

public class LatexFormulaFormatter implements FormulaFormatter,FormulaVisitor<String>{
	public String format(Formula f){
		return  f.accept(this) ;
	}
	
	public String visit(Constant constant)
	{
		return constant.asString();
	}
	
	public String visit(Variable v) {
		return v.asString();
	}

	public String visit(Sum f)
	{	
		StringBuilder stringBuilder = new StringBuilder("(");

		for (int index = 0; index < f.operands.length ; index ++){
			if (index > 0) {
				stringBuilder.append(" + ");
			}
			stringBuilder.append(f.operands[index].accept(this));
		}

		return stringBuilder.append(")").toString();
	}

	public String visit(Product f)
	{
		StringBuilder stringBuilder = new StringBuilder("(");

		for (int index = 0; index < f.operands.length ; index ++){
			if (index > 0) {
				stringBuilder.append(" /times ");
			}
			stringBuilder.append(f.operands[index].accept(this));
		}

		return stringBuilder.append(")").toString();
	}



}

