
public class RegisterFile {
	
	private Processor processor;
	private String[] registers;
	
	
	public RegisterFile(Processor processor) {
		this.processor = processor;
		registers = new String[32];
		
		//for testing purposes each register is initialized to contain its register number
		for (int i=0 ; i<32 ; i++)
			registers[i] = Processor.convertDecToBinUnsigned(i);
	}
	
		
	public void read(String readRegister1, String readRegister2) {
		
		int reg1 = Processor.convertBinToDecUnsigned(readRegister1);
		int reg2 = Processor.convertBinToDecUnsigned(readRegister2);
		processor.setReadData1(registers[reg1]);
		processor.setReadData2(registers[reg2]);
	}
	
	public void write(String writeRegister, String writeData, String regWrite) {
		
		if (regWrite.equals("1")) {
			int writeReg = Processor.convertBinToDecUnsigned(writeRegister);
			if (writeReg!=0)
				registers[writeReg] = writeData;
		}
	}
	
	public void view() {
		System.out.println("Register File Contents:");
		for (int i=0 ; i<registers.length ; i++)
			System.out.println("Register " + i + ": " + registers[i]);
	}
	
	
}
