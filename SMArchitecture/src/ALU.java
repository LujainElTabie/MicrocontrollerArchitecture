public class ALU{
    String ALUOp;
    String Op1;
    String Op2;
    public ALU(String ALUOp, String Op1, String Op2){
        this.ALUOp=ALUOp;
        this.Op1=Op1;
        this.Op2=Op2;
    }
    public String ALUCont() {
        switch(ALUOp){
            case "000":{
                // Sub
                return this.subOp(Op1, Op2);	//-> Sub
            }
            case "001":{
                //Add
                return this.addOp(Op1, Op2); //-> SUB
            }
            case "010":{
                //Multiply  
                return MultiOp(Op1, Op2);
            }
            case "011":{
                //Or
                return OROp(Op1, Op2);
            }
            case "100":{
                //AND
                return ANDOp(Op1, Op2);
            }
            case "101":{
                //Shift Right
                return slrOp(Op1,Op2);
            }
            case "110":{
                //Shift Left
                return sllOp(Op1, Op2);
            }
            case "111":{
                //Set on Less than
                return sltiOp(Op1,Op2);
            }
            default:return "Wrong ALUOp Signal";
        }
    }
    public String subOp(String Operand1,String Operand2) {
        return Processor.toBinary((int)Long.parseLong(Operand1,2) - (int)Long.parseLong(Operand2,2));
    }
    public String addOp(String Operand1, String Operand2) {
        return Processor.toBinary((int)Long.parseLong(Operand1,2) + (int)Long.parseLong(Operand2,2));
    }
    public String MultiOp(String Op1,String Op2){
        return Processor.toBinary((Integer.parseInt(Op1,2))*(Integer.parseInt(Op2,2)));
    } 
    public String ANDOp(String Operand1,String Operand2) {
        return Processor.toBinary((int)Long.parseLong(Operand1,2) & (int)Long.parseLong(Operand2,2));
    }
    public String OROp(String Operand1,String Operand2) {
        return Processor.toBinary((int)Long.parseLong(Operand1,2) | (int)Long.parseLong(Operand2,2));
    }
    public String slrOp(String Op1,String Op2){
        return Processor.toBinary((int)Long.parseLong(Op1,2)>>(int)Long.parseLong(Op2,2));
    }
    public String sllOp(String Op1,String Op2){
        return Processor.toBinary((int)Long.parseLong(Op1,2)<<(int)Long.parseLong(Op2,2));
    }
    public String sltiOp(String Operand1, String Operand2) {
        return Processor.toBinary((((int)Long.parseLong(Operand1,2)<(int)Long.parseLong(Operand2,2))? 1 : 0));
    }
}