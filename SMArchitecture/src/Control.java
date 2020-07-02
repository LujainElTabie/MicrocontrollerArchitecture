
public class Control {
	
	private Processor processor;
	
	
	public Control(Processor processor) {
		this.processor = processor;
	}

	
	public void decode(String opcode) {
		
		//executeControlSignals = {ALUControl, ALUSrc, Jump, Branch}
		String[] executeControlSignals = new String[4];
		//memoryControlSignals = {MemRead, MemWrite}
		String[] memoryControlSignals = new String[2];
		//writeBackControlSignals = {RegWrite, MemToReg}
		String[] writeBackControlSignals = new String[2];
		
		
		switch (opcode) {
			//sub
			case "00000":
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//add
			case "00001":
				executeControlSignals[0] = "001";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//add immediate
			case "00010":
				executeControlSignals[0] = "001";
				executeControlSignals[1] = "1";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//multiply
			case "00011":
				executeControlSignals[0] = "010";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//or
			case "00100":
				executeControlSignals[0] = "011";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//and immediate
			case "00101":
				executeControlSignals[0] = "100";
				executeControlSignals[1] = "1";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//shift right logical
			case "00110":
				executeControlSignals[0] = "101";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//shift left logical
			case "00111":
				executeControlSignals[0] = "110";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//load word
			case "01000":
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "1";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "1";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "1";
				break;
			//store word
			case "01001":
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "1";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "1";
				writeBackControlSignals[0] = "0";
				writeBackControlSignals[1] = "0";
				break;
			//branch on equal
			case "01010":
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "01";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "0";
				writeBackControlSignals[1] = "0";
				break;
			//branch on less than
			case "01011":
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "10";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "0";
				writeBackControlSignals[1] = "0";
				break;
			//set on less than immediate
			case "01100":
				executeControlSignals[0] = "111";
				executeControlSignals[1] = "1";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "0";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "1";
				writeBackControlSignals[1] = "0";
				break;
			//jump register
			case "01101":
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "1";
				executeControlSignals[3] = "0";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "0";
				writeBackControlSignals[1] = "0";
				break;
			//invalid instruction
			default:
				executeControlSignals[0] = "000";
				executeControlSignals[1] = "0";
				executeControlSignals[2] = "0";
				executeControlSignals[3] = "00";
				memoryControlSignals[0] = "0";
				memoryControlSignals[1] = "0";
				writeBackControlSignals[0] = "0";
				writeBackControlSignals[1] = "0";
		}
		
		processor.setExecuteControlSignals(executeControlSignals);
		processor.setMemoryControlSignals(memoryControlSignals);
		processor.setWriteBackControlSignals(writeBackControlSignals);
	}
	
	
}
