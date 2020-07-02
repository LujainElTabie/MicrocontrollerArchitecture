public class ProgramCounter {
    int PC;
    public ProgramCounter()
    {
        PC=0;
    }
    /**
	 * Get ProgramCounter value
	 */
    public int Get()
    {
        return PC;
    }
    /**
	 * Set ProgramCounter to input
	 */
    public void Set(int PC)
    {
        this.PC=PC;
    }
    /**
	 * Increment ProgramCounter by 1
	 */
    public void Increment()
    {
        PC++;
    }
    //     public static void main(String[] args)
    // {
    //     ProgramCounter hoba = new ProgramCounter();
    //     System.out.println(hoba.Get());
    //     hoba.Increment();
    //     hoba.Increment();
    //     System.out.println(hoba.Get());
    //     hoba.Set(123);
    //     System.out.println(hoba.Get());
    // }
    
}
