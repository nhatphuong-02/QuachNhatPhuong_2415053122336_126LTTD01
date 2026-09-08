//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
data class Student(
    var id: Int = 0,
    var fullName: String = "",
    var age: Int = 0,
    var major: String = "",
    var GPA: Double = 0.0
)
fun main() {
    println("Họ tên: Quách Nhật Phương\nMsv: 2415053122336\nLHP: 126LTTD01")
    val listOfStudents = mutableListOf<Student>()
    listOfStudents.add(Student(101, "Tran Minh Khoa", 20, "IT", 8.5))
    listOfStudents.add(Student(102, "Nguyen Thi Lan", 21, "Business", 7.2))
    listOfStudents.add(Student(103, "Hoang Duc Anh", 22, "IT", 9.1))
    listOfStudents.add(Student(104, "Le Quang Huy", 19, "Marketing", 4.5))
    listOfStudents.add(Student(105, "Pham Gia Bao", 23, "IT", 6.8))

    var choose = 10
    while(choose != 0) {
        println("\n\n=================STUDENT MANAGEMENT=====================")
        println("1. Add a student.")
        println("2. Display all students.")
        println("3. Search for a student.")
        println("4. Calculate the average GPA.")
        println("5. Find student with the highest GPA.")
        println("6. Remove a student.")
        println("7. Count students with a GPA greater than or equal 8.0.")
        println("8. Count students with a GPA less than 5.0.")
        println("9. Calculate the average GPA of students in a major")
        println("10. Find the oldest student.")
        println("11. Find student with a GPA between 7.0 and 8.5.")
        println("12. Find all students in a major.")
        println("13. Find students by partial name.")
        println("14. Sort students by GPA in descending order.")
        println("15. Find 3 students with the highest GPAs")
        println("16. Sort students by age.")
        println("17. Sort students by name")
        println("0. Exit.")
        println("========================================================")
        print("Enter a number: ")
        choose = readln().toInt()
    
        when (choose) {
            0-> break
            1->{
                println("\n\nADD A STUDENT")
                val newStudent = Student()
                print("Enter student id: ")
                newStudent.id = readln().toInt()
                if(listOfStudents.any { it.id == newStudent.id })
                    println("ID ALREADY EXISTS.")
                else {
                    print("Enter student full name: ")
                    newStudent.fullName = readln()
                    print("Enter student age: ")
                    newStudent.age = readln().toInt()
                    print("Enter student major: ")
                    newStudent.major = readln()
                    print("Enter student GPA: ")
                    newStudent.GPA = readln().toDouble()

                    listOfStudents.add(newStudent)
                    listOfStudents.sortBy { it.id }
                }
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
    
            2->{
                println("\n\n")
                println("==============================LIST STUDENTS==============================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in listOfStudents)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
    
            3->{
                println("\n\n")
                print("Enter student ID: ")
                val studentId = readln().toInt()
                val student =listOfStudents.find { it.id == studentId }
                if(student != null) {
                    println("STUDENT INFORMATION")
                    println("ID: ${student.id}")
                    println("Full name: ${student.fullName}")
                    println("Age: ${student.age}")
                    println("Major: ${student.major}")
                    println("GPA: ${student.GPA}")
                }
                else
                    println("STUDENT NOT FOUND")
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
    
            4->{
                println("\n\n")
                println("AVERAGE GPA: %.2f".format(listOfStudents.map{ student -> student.GPA}.average()))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
    
            5->{
                println("\n\n")
                val student = listOfStudents.maxByOrNull { it.GPA }
                if(student != null) {
                    println("STUDENT WITH HIGHEST GPA INFORMATION")
                    println("ID: ${student.id}")
                    println("Full name: ${student.fullName}")
                    println("Age: ${student.age}")
                    println("Major: ${student.major}")
                    println("GPA: ${student.GPA}")
                }
                else
                    println("STUDENT NOT FOUND")
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
    
            6->{
                println("\n\n")
                println("\n\nREMOVE A STUDENT ")
                print("Enter student ID: ")
                val studentId = readln().toInt()
                val student = listOfStudents.find { it.id == studentId }
                if(student != null) {
                    listOfStudents.remove(student)
                    println("STUDENT WITH ID $studentId HAS BEEN DELETED")
                }
                else
                    println("STUDENT NOT FOUND")
                listOfStudents.sortBy { it.id }
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            7->{
                println("\n\n")
                println("NUMBER OF STUDENTS WITH GPA GREATER THAN OR EQUAL TO 8.0: ${listOfStudents.count { it.GPA >= 8 }}")
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            8->{
                println("\n\n")
                println("NUMBER OF STUDENTS WITH GPA LOWER THAN 5.0: ${listOfStudents.count { it.GPA < 5 }}")
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            9->{
                println("\n\n")
                print("Enter major: ")
                val major = readln().trim()
                val avg = listOfStudents.filter { student -> student.major.equals(major,true) }.map{student->student.GPA}.average()
                println("AVERAGE GPA OF STUDENTS IN MAJOR ${major.uppercase()}: %.2f ".format(avg))
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            10->{
                println("\n\n")
                val student = listOfStudents.maxByOrNull { it.age }
                println("THE OLDEST STUDENT INFORMATION")
                if(student != null) {
                    println("ID: ${student.id}")
                    println("Full name: ${student.fullName}")
                    println("Age: ${student.age}")
                    println("Major: ${student.major}")
                    println("GPA: ${student.GPA}")
                }
                else println("LIST IS EMPTY")
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            11->{
                println("\n\n")
                val list = listOfStudents.filter { student -> student.GPA in 7.0 .. 8.5  }
                println("=====================LIST STUDENTS WITH GPA BETWEEN 7.0 AND 8.5======================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            12->{
                println("\n\n")
                print("Enter major: ")
                val major = readln().trim()
                val list = listOfStudents.filter { student -> student.major.equals(major,true) }
    
                println("=====================LIST STUDENTS IN ${major.uppercase()}=====================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            13->{
                println("\n\n")
                print("Enter keyword: ")
                val keyword = readln().trim()
                val list = listOfStudents.filter {student -> student.fullName.contains(keyword,true)}
    
                println("=====================SEARCH RESULT=====================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            14->{
                println("\n\n")
                val list = listOfStudents.sortedByDescending { student -> student.GPA }
                println("=====================LIST STUDENTS SORT DESCENDING BY GPA=====================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                  println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            15->{
                println("\n\n")
                val list = listOfStudents.sortedByDescending { student -> student.GPA }.take(3)
                println("=====================THE THREE STUDENTS WITH THE HIGHEST GPAs=====================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            16->{
                println("\n\n")
                val list = listOfStudents.sortedBy{ student -> student.age }
                println("=====================LIST STUDENTS SORT BY AGE=====================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            17->{
                println("\n\n")
                val list = listOfStudents.sortedBy{ student -> student.fullName }
                println("=====================LIST STUDENTS SORT BY NAME=====================")
                println("%-5s %-20s %5s %20s %5s".format("ID","NAME","AGE","MAJOR","GPA"))
                for (student in list)
                    println("%-5d %-20s %5d %20s %.2f".format(student.id,student.fullName,student.age,student.major,student.GPA))
    
                print("CONTINUE?(1,0): ")
                choose = readln().toInt()
            }
            else -> {
                println("INVALID CHOICE. PLEASE ENTER A NUMBER FROM 0 TO 16.")
    
            }
        }
    }
    print("PROGRAM EXITED")
}