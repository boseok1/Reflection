package reflection;

import java.awt.Container;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//스프링 로딩될 때
public class cosContainer {
	// invoke호출
	// 매개변수에 T를 걸기위함 <T>
	public <T> T invokeAnnotation(T instance) {
		// getClass가 클래스 이름 가져오는것임
		// getDeclaredMethods를 하면 그 클래스가 가지고 있는 모든 메소드를 가져옴
		// 모든 매서드를 스캔해서 methods 에 담아준다.
		Method[] methods = instance.getClass().getDeclaredMethods();

		// 메소드가 얼마나 있는지 모름
		for (Method m : methods) {
			// @NumCheck를 가지고 있으면
			if (m.isAnnotationPresent(NumCheck.class)) {
				// 이것을 제어 할 수 있다.
				// 스프링 톰캣이 실행될때 모든 클래스(Component)를 스캔해서 무엇을 할지 다 정해놨다는 것이다.
				// 이런 함수가 스프링에서 한번 실행된다.(톰캣이 실행될때)

				// 모든 필드를 가져옴 num1, num2
				Field f[] = instance.getClass().getFields();

				try {
					int num1 = f[0].getInt(instance); // instance = 실제 메모리주소
					int num2 = f[1].getInt(instance);

					System.out.println(num1);
					System.out.println(num2);

					if (num1 - num2 < 0) {
						System.out.println("금액이 부족합니다.");
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
