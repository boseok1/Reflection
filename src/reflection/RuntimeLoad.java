package reflection;

public class RuntimeLoad {
	public static void main(String[] args) {
		cosContainer c = new cosContainer();
		// ������ �޸𸮿� �� �޼ҵ�(��)�� ã�°� �߿���!

		Money m = c.invokeAnnotation(new Money());
		try {
			int money = m.minus();
			System.out.println("���� �ݾ��� :" + money);
		} catch (Exception e) {
			System.out.println("Money ������Ʈ�� ����������ʾҾ��");
		}

	}

}
