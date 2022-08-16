public class Program {
	public static void main(String[] args) {
		LabClass lab = new LabClass(1);

		lab.enrolStudent(new Student("John Doe", "001"));

		lab.setInstructor(new Instructor("Lorem Ipsum", "007", "Engineering"));

		lab.setRoom("42");
		lab.setTime("Wednesday, 8h20");

		lab.printList();
	}
}
