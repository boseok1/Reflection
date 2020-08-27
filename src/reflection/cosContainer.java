package reflection;

import java.awt.Container;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//������ �ε��� ��
public class cosContainer {
	// invokeȣ��
	// �Ű������� T�� �ɱ����� <T>
	public <T> T invokeAnnotation(T instance) {
		// getClass�� Ŭ���� �̸� �������°���
		// getDeclaredMethods�� �ϸ� �� Ŭ������ ������ �ִ� ��� �޼ҵ带 ������
		// ��� �ż��带 ��ĵ�ؼ� methods �� ����ش�.
		Method[] methods = instance.getClass().getDeclaredMethods();

		// �޼ҵ尡 �󸶳� �ִ��� ��
		for (Method m : methods) {
			// @NumCheck�� ������ ������
			if (m.isAnnotationPresent(NumCheck.class)) {
				// �̰��� ���� �� �� �ִ�.
				// ������ ��Ĺ�� ����ɶ� ��� Ŭ����(Component)�� ��ĵ�ؼ� ������ ���� �� ���س��ٴ� ���̴�.
				// �̷� �Լ��� ���������� �ѹ� ����ȴ�.(��Ĺ�� ����ɶ�)

				// ��� �ʵ带 ������ num1, num2
				Field f[] = instance.getClass().getFields();

				try {
					int num1 = f[0].getInt(instance); // instance = ���� �޸��ּ�
					int num2 = f[1].getInt(instance);

					System.out.println(num1);
					System.out.println(num2);

					if (num1 - num2 < 0) {
						System.out.println("�ݾ��� �����մϴ�.");
						return null;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		return instance;
	}

}
