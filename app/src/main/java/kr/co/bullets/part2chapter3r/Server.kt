package kr.co.bullets.part2chapter3r

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    Thread {
        // IP:Port
        // 192.168.0.1:8080
        val port = 8080
        val server = ServerSocket(port)

        while (true) {
            val socket = server.accept()

            // 스트림은 일방통행
            // socket.getInputStream() // 클라이언트로부터 들어오는 스트림 == 클라이언트의 socket.outputStream
            // socket.getOutputStream() // 클라이언트에게 데이터를 주는 스트림 == 클라이언트의 socket.inputStream

            val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            val printer = PrintWriter(socket.getOutputStream())

            var input: String? = "-1"
            while (input != null && input != "") {
                input = reader.readLine()
            }

            // Log.e("SERVER", "READ DATA $input")
            println("READ DATA $input")

            printer.println("HTTP/1.1 200 OK")
            printer.println("Content-Type: text/html\r\n")

            printer.println("<h1>Hello World</h1>")
            printer.println("\r\n")
            printer.flush()
            printer.close()

            reader.close()

            socket.close()
        }
    }.start()
}