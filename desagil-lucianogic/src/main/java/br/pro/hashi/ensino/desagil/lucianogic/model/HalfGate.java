package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private NandGate nandLeft;
	private NandGate nandRight;
	private NandGate nandUp;
	private NandGate nandDown;
	private NandGate nandMid;
	
	public HalfGate(){
		super(2,2);
		
		name = "Half";
		
		nandLeft = new NandGate();
		nandUp = new NandGate();
		nandMid = new NandGate();
		nandDown = new NandGate();
		nandRight = new NandGate();
		
		
		nandMid.connect(nandLeft, 1);
		nandUp.connect(nandLeft, 0);
		nandUp.connect(nandLeft, 1);
		nandDown.connect(nandLeft, 0);
		nandRight.connect(nandDown, 1);
		nandRight.connect(nandMid, 0);
		

		
	}
	@Override
		public boolean doRead(int index) {
			if (index == 0) {
				return nandRight.read();
			}
			
			else {
				return nandUp.read();
			}
		}
	
	@Override
	protected void doConnect(Emitter emitter,int index) {
		switch(index) {
		case 0:
			nandLeft.connect(emitter, 0);
			nandMid.connect(emitter, 0);
			break;
		case 1:
			nandLeft.connect(emitter, 1);
			nandDown.connect(emitter, 1);
			break;
		
	}
	

}
}
