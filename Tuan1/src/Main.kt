//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Họ tên: Quách Nhật Phương\nMsv: 2415053122336\nLHP: 126LTTD01")

    print("Bài 1: \n Các số từ 1 đến 10: ")
    for (i in 1 .. 10)
        print("$i ")

    println("\nBài 2: ")
    var sum = 0
    for(i in 1 ..100)
        sum+=i;

    println(" Tổng từ 1 đến 100: $sum")

    print("Bài 3: \n Các số chẵn từ 1 đến 20: ")
    for(i in 1 .. 10)
        print("${2*i} ")
}
