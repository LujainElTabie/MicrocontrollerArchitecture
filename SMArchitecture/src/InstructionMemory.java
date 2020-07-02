public class InstructionMemory {
    /**
	 * Number of Instructions in the InstructionMemory
     * <p> Gets incremented on MemWrite(String Instruction)
	 */
    int Size = 0;
	String [] Memory ;
    public InstructionMemory()
    {
        Memory =new String [1024];
    }
    /**
	 * Writes Instruction to the next empty cell in InstructionMemory.
	 */
    public void MemWrite(String Instruction)
    {
        this.Memory[this.Size++]=Instruction;
    }
     /**
	 * Reads Instruction in the given Memory Address.
	 */
    public String MemRead(int Address)
    {
        return this.Memory[Address];
    }
    // public static void main(String[] args) {
    //     InstructionMemory x = new InstructionMemory();
    //     x.MemWrite("1");
    //     x.MemWrite("2");
    //     x.MemWrite("3");
    //     x.MemWrite("4");
    //     x.MemWrite("5");
    // }
}
