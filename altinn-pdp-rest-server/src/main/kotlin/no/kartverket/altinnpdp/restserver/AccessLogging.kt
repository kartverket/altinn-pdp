package no.kartverket.altinnpdp.restserver

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.config.ApplicationConfig
import io.ktor.server.config.MapApplicationConfig
import io.ktor.server.plugins.calllogging.CallLogging
import org.slf4j.LoggerFactory

fun Application.configureAccessLogging() {
    if (!accessLogEnabled(environment.config)) return
    install(CallLogging) {
        logger = LoggerFactory.getLogger("access")
    }
}

internal fun accessLogEnabled(config: ApplicationConfig = MapApplicationConfig()): Boolean =
    config.boolean("accessLog.enabled", default = true)
