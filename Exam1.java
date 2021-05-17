// 한 줄 주석
/*
여러 줄 주석 (여러 줄 메모)
*/
/**
 * 
 * 프로그램 소스의 최소 단위 = class 프로그램 시작 클래스 (메인 클래스) => public class 클래스 이름 메인 클래스의
 * 이름은 소스 파일의 이름과 동일해야 하며 영어, 숫자, '_'언더바만 사용 가능하다. 첫 글자는 반드시 영어로만 구성 되어야 한다.
 */
public class Exam1 {
	/*
	 * 프로그램 시작점 => main 함수
	 */
	public static void main(String[] args) {
		System.out.println("Hello Java"); // ; (세미 콜론) 여기까지가 명령어 1개 이다 란 의미!
		System.out.print("자바");
		System.out.println();
		System.out.println("출발");

		// 여러 데이터 출력
		System.out.println(5); // 정수
		System.out.println(7.7); // 실수
		System.out.println('a'); // 문자
		System.out.println('홍'); // 문자
		System.out.println("a"); // 문자열
		System.out.println("홍길동");
		System.out.println(true); // boolean

		// 서식 지정 출력
		// 서식 문자
		// %d : 정수 %2d 2 : 자릿수, 문자의 개수
		// %f : 실수 %10.2f 10 : 전체 자리 수, .2 : 소수점 자리 수
		// %s : 문자열% %10s 10 : 자리 수
		// 특수 문자 : \n 키보드의 enter를 나타냄
		// => 1줄 넘김 문자
		System.out.printf("%d %f %s\n", 5, 7.7, "Hello");
		System.out.printf("%2d %10.2f %10s\n", 5, 7.7, "Hello");

	}
}
