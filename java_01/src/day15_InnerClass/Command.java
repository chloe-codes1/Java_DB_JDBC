package day15_InnerClass;

public interface Command {

	
	// [ interface의 활용성 ] -> Test04를 통해 확인 가능
	
	void exec();
	//-> override를 해야만 하는 강제성이 있는 abstract method
	
	default public void check() {}
	// -> override 하지 않아도 되는 강제성이 없는 method
	// -> *default 처리하면 body부가 있는 method를 interface 안에 만들 수 있다*
}

class DeleteCommand implements Command{
	
	@Override
	public void exec() {
		
		System.out.println("DeleteCommand 수행");
	}
}

class UpdateCommand implements Command{
	
	@Override
	public void exec() {
		
		System.out.println("UpdateCommand 수행");
	}
}

