import com.sun.xml.internal.ws.util.StringUtils;

public class XMLFormulaFormatter implements FormulaFormatter, FormulaVisitor<String> {
	int indentLevel;
	int indentWidth;
	public XMLFormulaFormatter(int indentLevel, int indentWidth) 
	{
		this.indentLevel = indentLevel;
		this.indentWidth = indentWidth;
	}

	public String format(Formula f){
		return f.accept(this);
	}

	public String visit(Constant c)
	{
		//return "<const>" + constant.asString() +"</const>\r\n";
		StringBuilder stringBuilder = new StringBuilder("");
		for (int n = 0; n < indentLevel ; n ++){
			stringBuilder.append("   ");
		}
		
		stringBuilder.append("<const>" + c.asString()+ "</const>\r\n");
		
		for (int n = 0; n < indentLevel ; n ++){
			stringBuilder.append("   ");
		}

		return stringBuilder.toString();

	}

	@Override
	public String visit(Variable v) 
	{

		//return this.indentLevel+"<var>" + v.asString() +"</var>\r\n";

		StringBuilder stringBuilder = new StringBuilder();
		for (int n = 0; n < indentLevel ; n ++){
			stringBuilder.append("   ");
		}
		stringBuilder.append("<var>" + v.asString()+ "</var>\r\n");
		return stringBuilder.toString();
	}

	public String visit(Sum f){
		StringBuilder stringBuilder = new StringBuilder("");
		for (int n = 0; n < indentLevel ; n ++){
			stringBuilder.append("   ");
		}
		
		stringBuilder.append("<sum>\r\n");
		for (int index = 0; index < f.operands.length ; index ++){
			for (int n = 0; n < indentLevel ; n ++){
				stringBuilder.append("   ");
			}
			stringBuilder.append(new XMLFormulaFormatter(indentLevel + 1, indentWidth).format(f.operands[index]));
		}
		
		for (int n = 0; n < indentLevel ; n ++){
			stringBuilder.append("   ");
		}
		return stringBuilder.append("</sum>\r\n").toString();
	}
	
	public String visit(Product f){

		//return "< product >\r\n   " + f.asString() +"\r\n</ product >";
		StringBuilder stringBuilder = new StringBuilder("<product>\r\n");
		for (int index = 0; index < f.operands.length ; index ++){
			stringBuilder.append(new XMLFormulaFormatter(indentLevel + 1, indentWidth).format(f.operands[index]));
		}
		return stringBuilder.append("</product>\r\n").toString();
	}
}
