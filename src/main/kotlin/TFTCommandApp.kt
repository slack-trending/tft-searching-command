import com.slack.api.bolt.App
import com.slack.api.bolt.socket_mode.SocketModeApp
import handler.TFTHandler

fun main() {
    val app = App()
    val tftHandler = TFTHandler()

    app.command("/tft", tftHandler::search)

    SocketModeApp(app).start()
}