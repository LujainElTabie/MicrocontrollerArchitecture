
public class DataMemory {
	
	Processor processor;
	Block[] cache;
	String[] memory;
	
	
	public DataMemory(Processor processor) {
		this.processor = processor;
		cache = new Block[128];
		for (int i=0 ; i<cache.length ; i++)
			cache[i] = new Block();
		
		memory = new String[1024];
		for (int i=0 ; i<memory.length ; i++)
			memory[i] = Processor.convertDecToBinUnsigned(i);
    }
	
	public void readData(int address) {
		if(cache[address%128].validBit==1 && cache[address%128].tag==address/128) {
			processor.setMemoryReadData(cache[address%128].data);
		}
		else {
			cache[address%128].data = memory[address];
			cache[address%128].tag = address/128;
			cache[address%128].validBit = 1;
			processor.setMemoryReadData(memory[address]);
		}
	}
	
	
	public void writeData(int address, String data) {
		if(cache[address%128].validBit==0 || cache[address%128].tag!=address/128) {
			cache[address%128].data = memory[address];
			cache[address%128].tag = address/128;
			cache[address%128].validBit = 1;
		}
		cache[address%128].data=data;
		memory[address]=data;
	}
	
	
	public void viewHead() {
		System.out.println("Data Memory Contents:");
		System.out.println("(first 50 addresses only)");
		for (int i=0 ; i<50 ; i++)
			System.out.println("Address " + i + ": " + memory[i]);
	}
	
	
}
