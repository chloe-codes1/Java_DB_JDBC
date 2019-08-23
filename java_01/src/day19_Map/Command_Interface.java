package day19_Map;

@FunctionalInterface
public interface Command_Interface {
	// [Functional  Interface ]
	//	: abstract method가 하나인 interface 
	//		-> 람다식으로 표현 가능하다
	void exec();
	
	default void print() {
		System.out.println("~~~~~~~~~~~~");
	}
}

class DeleteCommand implements Command_Interface{

	@Override
	public void exec() {
		System.out.println("DeleteCommand 수행");
	}
}

class SelectCommand implements Command_Interface{

	@Override
	public void exec() {
		System.out.println("SelectCommand 수행");
	}
}
class InsertCommand implements Command_Interface{

	@Override
	public void exec() {
		System.out.println("InsertCommand 수행");
	}
}
class UpdateCommand implements Command_Interface{

	@Override
	public void exec() {
		System.out.println("UpdateCommand 수행");
	}
}