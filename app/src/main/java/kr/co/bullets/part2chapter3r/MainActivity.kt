package kr.co.bullets.part2chapter3r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.ServerSocket
import java.net.Socket

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("http://192.168.0.122:8080")
            .build()

        val callback = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("CLIENT", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    Log.e("CLIENT", "${response.body?.string()}")
                }
            }
        }

        client.newCall(request).enqueue(callback)

//        try {
//            val response = client.newCall(request).execute()
//            Log.e("CLIENT", "${response.body?.toString()}")
//        } catch (e: Exception) {
//            Log.e("CLIENT", e.toString())
//        }

//        Thread {
//            try {
//                // 에뮬레이터: 10.0.2.2
//                // 실기기: 실제 IP
//                val socket = Socket("192.168.0.122", 8080)
//                val printer = PrintWriter(socket.getOutputStream())
//                val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
//
//                printer.println("GET / HTTP/1.1")
//                printer.println("Host: 192.168.0.122:8080")
//                printer.println("User-Agent: android")
//                printer.println("\r\n")
//                printer.flush()
//
//                var input: String? = "-1"
//                while (input != null) {
//                    input = reader.readLine()
//                    Log.e("CLIENT", input)
//                }
//                reader.close()
//                printer.close()
//                socket.close()
//            } catch (e: Exception) {
//                Log.e("Client", e.toString())
//            }
//        }.start()
    }
}