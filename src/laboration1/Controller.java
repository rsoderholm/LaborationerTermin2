package laboration1;

public class Controller {

	public static void main(String[] args) {
		DString dstr = new DString("Laboration");
		dstr.append(' ').append('1').append(new DString("\nUppgift3"));
		System.out.println(dstr);
		dstr.delete(2).delete(4, 6).delete(8);
		System.out.println(dstr);
		System.out.println(dstr.charAt(1));
	}

}
