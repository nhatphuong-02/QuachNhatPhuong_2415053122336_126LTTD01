//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Họ tên: Quách Nhật Phương\nMsv: 2415053122336\nLHP: 126LTTD01")

    println("\nNhập điểm 3 môn (lần lượt là math, programming, database):")
    val points = DoubleArray(3)
    for (i in 0 until 3){
        print("Nhập điểm môn thứ ${i+1}: ")
        points[i] = readln().toDouble()
    }
    val avg = points.average()
    println("\nTổng điểm: ${String.format("%.2f", points.sum())}")
    println("Điểm trung bình: ${String.format("%.2f",avg)}")
    println("Điểm cao nhất:  ${String.format("%.2f",points.maxOrNull()!!)}")

    if(avg>=5)     println("Sinh viên đạt")
    else    println("Sinh viên không đạt")
}