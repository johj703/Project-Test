// �� �� �ּ�
/*
���� �� �ּ� (���� �� �޸�)
*/
/**
 * 
 * ���α׷� �ҽ��� �ּ� ���� = class ���α׷� ���� Ŭ���� (���� Ŭ����) => public class Ŭ���� �̸� ���� Ŭ������
 * �̸��� �ҽ� ������ �̸��� �����ؾ� �ϸ� ����, ����, '_'����ٸ� ��� �����ϴ�. ù ���ڴ� �ݵ�� ����θ� ���� �Ǿ�� �Ѵ�.
 */
public class Exam1 {
	/*
	 * ���α׷� ������ => main �Լ�
	 */
	public static void main(String[] args) {
		System.out.println("Hello Java"); // ; (���� �ݷ�) ��������� ��ɾ� 1�� �̴� �� �ǹ�!
		System.out.print("�ڹ�");
		System.out.println();
		System.out.println("���");

		// ���� ������ ���
		System.out.println(5); // ����
		System.out.println(7.7); // �Ǽ�
		System.out.println('a'); // ����
		System.out.println('ȫ'); // ����
		System.out.println("a"); // ���ڿ�
		System.out.println("ȫ�浿");
		System.out.println(true); // boolean

		// ���� ���� ���
		// ���� ����
		// %d : ���� %2d 2 : �ڸ���, ������ ����
		// %f : �Ǽ� %10.2f 10 : ��ü �ڸ� ��, .2 : �Ҽ��� �ڸ� ��
		// %s : ���ڿ�% %10s 10 : �ڸ� ��
		// Ư�� ���� : \n Ű������ enter�� ��Ÿ��
		// => 1�� �ѱ� ����
		System.out.printf("%d %f %s\n", 5, 7.7, "Hello");
		System.out.printf("%2d %10.2f %10s\n", 5, 7.7, "Hello");

	}
}
