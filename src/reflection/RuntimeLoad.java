package reflection;

public class RuntimeLoad {
	public static void main(String[] args) {
		cosContainer c = new cosContainer();
		// 실제로 메모리에 뜬 메소드(값)를 찾는게 중요함!

		Money m = c.invokeAnnotation(new Money());
		try {
			int money = m.minus();
			System.out.println("남은 금액은 :" + money);
		} catch (Exception e) {
			System.out.println("Money 오브젝트가 만들어지지않았어요");
		}

	}

}
