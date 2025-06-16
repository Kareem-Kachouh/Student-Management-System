import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner c = new Scanner(System.in);
		Scanner console = new Scanner(System.in);

		CourseList l1 = new CourseList("name");

		String[] Majors = { "Computer Science" };
       
		Course CS001 = new Course("Introduction to Programming", "CS001");
		Course CS002 = new Course("Object Oriented Programming", "CS002");
		Course CS003 = new Course("Data Structures", "CS003");
		Course CS004 = new Course("Software Engineering", "CS004");
		Course CS005 = new Course("Concepts of Programming Languages", "CS005");
		Course CS006 = new Course("Operating Systems", "CS006");
		Course[] CS000 = { CS001, CS002, CS003, CS004, CS005, CS006 };
		for (int i = 0; i < CS000.length - 1; i++) {
			CS000[i + 1].addPrerequisite(CS000[i]);
		}
		

		Course CS101 = new Course("Introduction to Python", "CS101");
		Course CS102 = new Course("Web Programming", "CS102");
		Course CS103 = new Course("Image Processing", "CS103");
		Course CS104 = new Course("Database Systems", "CS104");
		Course CS105 = new Course("Computer Networks", "CS105");
		Course CS106 = new Course("Computer Security", "CS106");
		Course[] CS100 = { CS101, CS102, CS103, CS104, CS105, CS106 };
		for (int i = 0; i < CS100.length - 1; i++) {
			CS100[i + 1].addPrerequisite(CS100[i]);
		}

		Course CS201 = new Course("Introduction To C++", "CS201");
		Course CS202 = new Course("Discrete Structures I", "CS202");
		Course CS203 = new Course("Discrete Structures II", "CS203");
		Course CS204 = new Course("Machine Learning", "CS204");
		Course CS205 = new Course("Artifical Intelligence", "CS205");
		Course[] CS200 = { CS201, CS202, CS203, CS204, CS205 };
		for (int i = 0; i < CS200.length - 1; i++) {
			CS200[i + 1].addPrerequisite(CS200[i]);
		}

		Course CS301 = new Course("Digital Circuits I", "CS301");
		Course CS302 = new Course("Digital Circuits II", "CS302");
		Course CS303 = new Course("Computer Organization & Architecture",
				"CS303");
		Course CS304 = new Course("Theory of Computation", "CS304");
		Course CS305 = new Course("Fundamentals of Algorithms", "CS305");
		Course CS306 = new Course("Data Mining", "CS306");
		Course[] CS300 = { CS301, CS302, CS303, CS304, CS305, CS306 };
		for (int i = 0; i < CS300.length - 1; i++) {
			CS300[i + 1].addPrerequisite(CS300[i]);
		}

		Course CS405 = new Course("Computer and Information", "CS405");
		Course CS406 = new Course("Data Sciences", "CS406");
		Course[] CS400 = { CS405, CS406 };
		for (int i = 0; i < CS400.length - 1; i++) {
			CS400[i + 1].addPrerequisite(CS400[i]);
		}

		Course M001 = new Course("Calculus II", "M001");
		Course M002 = new Course("Probability and Statistics", "M002");
		Course M003 = new Course("Linear Algebra", "M003");
		Course M004 = new Course("Numerical Methods", "M004");
		Course[] M000 = { M001, M002, M003, M004 };
		for (int i = 0; i < M000.length - 1; i++) {
			M000[i + 1].addPrerequisite(M000[i]);
		}
        Course[][] cs= {CS000,CS100,CS200,CS300,CS400,M000};
    // int csNB= CS001.countMajorCourses(cs);
		int opt;
		CourseList CS = new CourseList("Computer Science");
		System.out.println("       STUDENT MANAGEMENT SYSTEM");
		System.out.println("-------------------------------------\n\n");
		BSTStudent records = new BSTStudent();
		do {

			Student s1 = new Student();
			// options available for system administrator
			System.out.println();
			System.out.println("Choose one of the options below :\n");
			System.out.println("1-Add Student Record(Only for semester 1 students)");
			System.out.println("2-Delete Student Record");
			System.out.println("3-Modify Student Record");
			System.out.println("4-Search Student Record");
			System.out.println("5-Display all existing records");
			System.out.println("6-Exit");
            
            opt = console.nextInt();

			switch (opt) {

			// if he selected the first option we add a student to record
			case 1: {
				System.out.println();
				System.out.println(" DEPARTEMENT OF COMPUTER SCIENCE");
				System.out.println("*********************************");
				System.out.println();
				System.out.print("Enter First Name: ");
				String fn = console.next();
				s1.setFname(fn);
				
				System.out.println();

				System.out.print("Enter Last Name: ");
				String ln = console.next();
				s1.setLname(ln);
				System.out.println();
			 
				String maj="computer science";
				s1.setMajor(maj);
			    console.nextLine();

				System.out.print("Enter Student ID: ");
				int id = console.nextInt();
				s1.setId(id);
				System.out.println();
				int sem = 1;
				s1.setSemesterNb(sem);
				if (records.isFoundStudent(s1.getId())) {
					System.out.println("The student already exists!!!");
					break;
				}
				System.out.print("This is the student's first semester.");
				

				System.out.println();

				if (maj.equalsIgnoreCase(Majors[0])) {
					// checks if major is
					// found and display the
					// major's courses
					System.out.println("Courses available in semester " + sem
							+ " of Computer Science:\n");

				
						Course[] sm1 = { CS001, CS101, CS201, CS301, M001 };
						for (int i = 0; i < sm1.length; i++) {
							System.out.println(sm1[i].code + "-"
									+ sm1[i].getName());
						}
						System.out.println();

					
						int n;
						boolean flag2 = true;
						do {
							System.out
									.println("-Press 1 to enter the code of the courses that the student want to register in.");
							System.out
									.println("-Press 2 to exit registration.");

							n = console.nextInt();
							switch (n) {

							case 1: {
								String ans;
								if (flag2) {
									System.out
											.println("The Student must be registered in at least 3 course to be elligible for the semester.");
								}
								do {//tmp nb of courses registered
									System.out.println();
									System.out
											.println("Please enter the course code.");
									String cd = console.next();
									boolean flag = true;
									for (int i = 0; i < sm1.length; i++) {
										if (cd.equalsIgnoreCase(sm1[i].getCode())&& !s1.coursesTaken.isFound(sm1[i])) {
											
											s1.registerCourse(sm1[i]);
                                           
											
											flag = false;
										}
									}

									if (flag) {
										System.out
												.println("Cannot add course!!!");
									}

									System.out.println();

									System.out
											.println("Do you wish to register the student in another course? (y/n)");
									ans = console.next();
									if (s1.coursesTaken.length() >= 3) {
										flag2 = false;
									}

								} while (ans.equals("y"));
								System.out.println("Courses registered : ");
								System.out.println("--------------------");
								s1.coursesTaken.display();
								break;
							}

							case 2: {
								System.out.println("Exiting registration...");

								if (flag2) {
									System.out.println();
									System.out
											.println("Registration was incomplete due to elligiblity-->Student record was not saved. ");
									// Student must register at least 3 courses
								} else {
									System.out
											.println("registration Successfull.");
									records.insert(s1);
							
								}
								break;
							}
							default:
								System.out.println("Invalid input!!!");
								break;
							}

						}

						while (n != 2);

					


				}

				break;
			}
			
			// delete a record
			case 2: {
				System.out
						.println("Please enter the ID of the Student to delete his record :");
				int n = console.nextInt();

				if (records.isFoundStudent(n)) {
					records.deleteByID(n);
					System.out.println("The record of the Student whose ID is "
							+ n + " have been successfully deleted.");
				} else
					System.out.println("Student with the ID " + n
							+ " does not exist!!!");
				break;

			}

			case 3: { 
				// in this case we will modify some info for student or
				// add courses for the
				// semester he's registering to

				System.out.println("To modify a Student's record, please enter his ID: ");
				int n = console.nextInt();

				if (records.isFoundStudent(n)) {
					System.out.println();
					Student s2 = records.search(n);

					
					s2.display();
					System.out.println("Courses taken by the Student:");
					System.out.println("------------------------------");
					
					s2.coursesTaken.display();
					System.out.println();
					int op;
					do {
						System.out.println();
						System.out.println("1-Modify First Name");
						System.out.println("2-Modify Last Name");
						System.out.println("3-Modify ID");
						System.out.println("4-Register in a new Semester");
						System.out.println("5-Exit");
						op = console.nextInt();

						switch (op) {

						case 1: {
							System.out
									.println("Please modify the Student's First Name: ");
							String u = console.next();
							s2.setFname(u);
							System.out.println();
							break;
						}

						case 2: {
							System.out
									.println("Please modify the Student's Last Name: ");
							String u = console.next();
							s2.setLname(u);
							System.out.println();
							break;
						}
						case 3: {
							System.out
									.println("Please modify the Student's ID: ");
							int u = console.nextInt();
							s2.setId(u);
							System.out.println();
							break;
						}
					
						case 4: {
							if(s2.coursesTaken.length()<29) {
							System.out.println("The Student has completed semester "
											+ s2.getSemesterNb() + "\n");

							System.out.println("Courses completed by the Student: ");
							System.out.println("----------------------------------- ");
							s2.coursesTaken.display();

							System.out.println("Do you wish to register the Student for semester "
											+ (s2.getSemesterNb() + 1)+ "? (y/n)");
							String a = console.next();
							int tmpSem = s2.getSemesterNb() + 1;
							
							if (a.equals("y")) {

								System.out.println();

								if (s2.getMajor().equalsIgnoreCase(Majors[0])) {
									// checks if major is found and display the major courses
									System.out.println("Courses available in semester "+ tmpSem+ " of Computer Science:\n");
									Course[] sm1 = { CS001, CS101, CS201,
											CS301, M001 };
									Course[] sm2 = { CS002, CS102, CS202,
											CS302, M002 };
									Course[] sm3 = { CS003, CS103, CS203,
											CS303, M003 };
									Course[] sm4 = { CS004, CS104, CS204,
											CS304, M004 };
									Course[] sm5 = { CS005, CS105, CS205,
											CS305, CS405 };
									Course[] sm6 = { CS006, CS106, CS306, CS406 };
								
									
									Course[][] sm = { sm1, sm2, sm3, sm4, sm5,
											sm6 };
									int semNb = 0;
									switch (tmpSem) {
									case 2: {
									
										semNb = 2;
										break;
									}
									case 3: {
										
										semNb = 3;
										break;
									}
									case 4: {
									
										semNb = 4;
										break;
									}
									case 5: {
									
										semNb = 5;
										break;
									}
									case 6: {
									
										semNb = 6;
										break;
									}
							/*	case 7:{
										semNb=6;
									}
									case 8:{
										semNb=6;
									}
									*/
									default:
								       semNb=6;
										break;
									}

								
									
									ArrayList<Course> crses = new ArrayList<Course>();
									for (int i = 0; i < semNb; i++) {
										System.out.println("Courses not registered during semester "+ (i + 1));
										for (int j = 0; j < sm[i].length; j++) {
											if (!s2.coursesTaken.isFound(sm[i][j]))
												System.out.println(sm[i][j].code+ "-"+ sm[i][j].getName());
										}System.out.println();
									}

								
									int n1;
									boolean flag2 = true;
									do { 
										System.out.println("-Press 1 to enter the code of the courses that the student want to register in.");
										System.out.println("-Press 2 to exit registration.");

										n1 = console.nextInt();
										switch (n1) {

										case 1: {
											String ans;
											if (flag2) {
												System.out.println("The Student must be registered in at least 3 courses to be elligible for the semester.");
											}
											do {
												System.out.println();
												System.out.println("Please enter the course code.");
												String cd = console.next();
												boolean flag = true;
										
												
												for (int i = 0; i < semNb; i++) {
													for (int j = 0; j < sm[i].length; j++) {
														if (cd.equalsIgnoreCase(sm[i][j].getCode())&& !s2.coursesTaken.isFound(sm[i][j]) &&s2.canRegisterCourse(sm[i][j])) {
															 System.out.println(sm[i][j].getName() +" course registered successfully.");										
															 crses.add(sm[i][j]);
															 s2.registerCourse(sm[i][j]);						
															flag = false;
														}
													}
												}

												if (flag) {
													System.out.println("Cannot add course!!!");
												}

												System.out.println();

												System.out.println("Do you wish to register the student in another course? (y/n)");
												ans = console.next();
												if (s2.coursesTaken.length() >= 3 || crses.size() >2) {
													flag2 = false;
												}

											} while (ans.equals("y"));
											System.out.println("Courses Registered: ");
											System.out.println("--------------------");
											s2.coursesTaken.display();
											break;
										}

										case 2: {
											System.out.println("Exiting registration...");
											
											if(crses.size() < 3) flag2 = true;
											if(tmpSem > 6) flag2 = false;
											if (flag2) {
												
												System.out.println();
												System.out.println("Registration was incomplete due to elligiblity-->Student record was not saved. ");
												for(int i = 0; i < crses.size(); i++) {
													s2.coursesTaken.removeCourse(crses.get(i));
												}
											
											}else{
												System.out.println();
												System.out.println("Registration sucessfull.");
												s2.setSemesterNb(tmpSem);	
											}					
											break;
										}
										default:
											System.out.println("Invalid input!!!");
											break;
										}

									}
									while (n1 != 2);

								}
							}

							else {
								System.out.println("No change has occured with the Student's record.");
								break;
							}

						}
							else System.out.println("No more semesters needed,Student has completed all Courses, CONGRATULATIONS!!!");
						}

						}} while (op != 5); 

				}
				break;
			}

			case 4: {
				System.out.println("Please enter the ID of the Student to check his record :");
				int n = console.nextInt();
				if (records.isFoundStudent(n)) {

					records.search(n).display();
					System.out.println("Courses taken by the Student:");
					System.out.println("------------------------------");
					records.search(n).coursesTaken.display();

				} else
					System.out.println("Student with the ID " + n
							+ " does not exist!!!");
				break;

			}
			case 5: {
				if(!records.isEmpty()) {
				System.out.println("Displaying all available Student records: ");
				System.out.println("------------------------------------------");
				System.out.println();
				records.display();}
				else System.out.println("No records currently exist.");
				break;
			}
			

			case 6: {
				System.out.println("");
				System.out.println("Thank you for using our System");
				break;
			}
			default: {
				System.out.println("Please enter a valid number!!!");
				break;
			}
			}

		}

		while (opt != 6);
	}
}
